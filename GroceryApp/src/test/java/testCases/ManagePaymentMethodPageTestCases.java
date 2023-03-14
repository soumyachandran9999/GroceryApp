package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManagePaymentMethodPage;
import utilities.RetryUtils;

public class ManagePaymentMethodPageTestCases extends BaseClass {
	LoginPage lp;
	ManagePaymentMethodPage mpmp;

	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheTitleOfManagePaymentMethodPage() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		mpmp = new ManagePaymentMethodPage(driver);
		mpmp.clickManagePaymentMethodsTab();
		String actualResult = mpmp.getTitleOfManagePaymentMEthodsPage();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHETITLEOFMANAGEPAYMENTMETHODPAGE;
		Assert.assertEquals(actualResult, expectedResult,
				Constant.ERRORMESSAGEOFVERIFYTHETITLEOFMANAGEPAYMENTMETHODPAGE);
	}

	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheUrlOfManagePaymentMethodPage() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mpmp = new ManagePaymentMethodPage(driver);
		mpmp.clickManagePaymentMethodsTab();
		String actualResult = mpmp.getTheUrlOfThePage();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEURLOFMANAGEPAYMENTMETHEDPAGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEURLOFMANAGEPAYMENTMETHEDPAGE);
	}

	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheBackgroundColorOfResetButton() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mpmp = new ManagePaymentMethodPage(driver);
		mpmp.clickManagePaymentMethodsTab();
		String actualResult = mpmp.getTheBackgroundColorOfResetButton();
		String expectedResult = prop.getProperty("ExpectedResultofVerifyTheBackgroundColorOfResetButton");
		Assert.assertEquals(actualResult, expectedResult,
				Constant.ERRORMESSAGEOFVERIFYTHEBACKGROUNDCOLOROFRESETBUTTONINMANAGEEXPENSEPAGE);
	}
}
