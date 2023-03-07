package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class LoginPageTestCases extends BaseClass {

	LoginPage lp;
	ExcelRead er;

	@Test(groups = {"High"}, priority = 3)
	public void verifyTheTextOnSignInBUtton() {
		try {
			testBasic();
			lp = new LoginPage(driver);
			String actualResultString = lp.getTheTextOfSignInButton();
			String expectedResultString = prop.getProperty("ExpectedResultOfverifyTheTextOnSignInBUtton");
			Assert.assertEquals(actualResultString, expectedResultString,
					Constant.EXPECTEDRESULTOFVERIFYTEXTOFLOGINBUTTON);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(groups = {"High", "Critical"}, priority = 1)
	public void verifyTheBrandTextDisplayedInTheLoginPage() {
		lp = new LoginPage(driver);
		String actualResultString = lp.getTheBrandTextInTheLoginPage();
		String expectedResultString = Constant.EXPECTEDRESULTOFBRANDTEXTINLOGINPAGE;
		Assert.assertEquals(actualResultString, expectedResultString, Constant.ERRORMESSAGEOFBRANDNAMEINLOGINPAGE);
	}

	@Test(groups = {"Low"}, priority = 4)
	public void verifyTheUncheckOfRememberMeCheckBox() {
		try {
			testBasic();
			lp = new LoginPage(driver);
			boolean actualResult = lp.untickRememberMecheckBox();
			boolean expectedResult = Constant.EXPECTEDRESULTOFREMEMBERMEUNCHECK;
			Assert.assertEquals(actualResult, expectedResult,
					prop.getProperty("ErrorMessageForVerifyTheUncheckOfRememberMeCheckBox"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(groups = {"High", "Critical"}, priority = 2)
	public void verifyTheLoginBoxMessage() {
		try {
			testBasic();
			lp = new LoginPage(driver);
			String actualResult = lp.getTheLoginBoxMessage();
			String expectedResult = prop.getProperty("ExpectedResultoftheLoginBoxMessage");
			Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHELOGINBOXMESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
