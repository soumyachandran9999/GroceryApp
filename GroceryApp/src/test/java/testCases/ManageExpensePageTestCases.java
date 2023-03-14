package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageExpensePage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class ManageExpensePageTestCases extends BaseClass {
	LoginPage lp;
	ManageExpensePage mep;
	ExcelRead er;

	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheSelectionOfManageExpenseUnderManageExpenseDropDown() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mep = new ManageExpensePage(driver);
		mep.clickOnManageExpenseDropDown();
		String actualResult = mep.selectManageExpenseButton();
		String expectedResult = "List Expense";
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFSELECTIONOFMANAGEEXPENSERADIOBUTTON);
	}

	@Test(groups = { "Regression" },dataProvider = "data-provider",retryAnalyzer = RetryUtils.class)
	public void verifyTheNewExpenseCategoryAdded(String categoryName) throws InterruptedException, IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mep = new ManageExpensePage(driver);
		mep.clickOnManageExpenseDropDown();
		mep.addNewExpenseCategory(categoryName);
		boolean actualResult = mep.verifyTheAddedCategory(categoryName);
		boolean expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHENEWEXPENSECATEGORYADDED;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHENEWEXPENSECATEGORYADDED);
		mep.deleteTheExpenseCategory(categoryName);
	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] {{"Cash Voucher"}};

	}
}
