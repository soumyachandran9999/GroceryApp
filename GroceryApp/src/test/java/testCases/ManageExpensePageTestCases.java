package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageExpensePage;

public class ManageExpensePageTestCases extends BaseClass {
	LoginPage lp;
	ManageExpensePage mep;

	@Test
	public void verifyTheSelectionOfManageExpenseUnderManageExpenseDropDown() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		mep = new ManageExpensePage(driver);
		mep.clickOnManageExpenseDropDown();
		boolean actualResult = mep.selectManageExpenseButton();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFSELECTIONOFMANAGEEXPENSERADIOBUTTON);
	}
}
