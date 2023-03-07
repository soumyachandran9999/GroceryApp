package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManagePaymentMethodPage;

public class ManagePaymentMethodPageTestCases extends BaseClass {
	LoginPage lp;
	ManagePaymentMethodPage mpmp;

	@Test
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

	@Test
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

	@Test
	public void verifyTheBackgroundColorOfResetButton() {
		try {
			testBasic();
			lp = new LoginPage(driver);
			lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
			mpmp = new ManagePaymentMethodPage(driver);
			mpmp.clickManagePaymentMethodsTab();
			String actualResult = mpmp.getTheBackgroundColorOfResetButton();
			String expectedResult = prop.getProperty("ExpectedResultofVerifyTheBackgroundColorOfResetButton");
			Assert.assertEquals(actualResult, expectedResult,
					Constant.ERRORMESSAGEOFVERIFYTHEBACKGROUNDCOLOROFRESETBUTTONINMANAGEEXPENSEPAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
