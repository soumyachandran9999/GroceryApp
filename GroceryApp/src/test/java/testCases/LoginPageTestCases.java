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
import utilities.RetryUtils;

public class LoginPageTestCases extends BaseClass {

	LoginPage lp;
	ExcelRead er;

	@Test(groups = { "High" }, priority = 3, retryAnalyzer = RetryUtils.class)
	public void verifyTheTextOnSignInBUtton() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		String actualResultString = lp.getTheTextOfSignInButton();
		String expectedResultString = prop.getProperty("ExpectedResultOfverifyTheTextOnSignInBUtton");
		Assert.assertEquals(actualResultString, expectedResultString,
				Constant.ERRORMESSAGEOFVERIFYTEXTOFLOGINBUTTON);

	}

	@Test(groups = { "High", "Critical" }, priority = 1, retryAnalyzer = RetryUtils.class)
	public void verifyTheBrandTextDisplayedInTheLoginPage() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		String actualResultString = lp.getTheBrandTextInTheLoginPage();
		String expectedResultString = prop.getProperty("ExpectedResultOfverifyTheBrandTextDisplayedInTheLoginPage");
		Assert.assertEquals(actualResultString, expectedResultString, Constant.ERRORMESSAGEOFBRANDNAMEINLOGINPAGE);

	}

	@Test(groups = { "Low" }, priority = 4, retryAnalyzer = RetryUtils.class)
	public void verifyTheUncheckOfRememberMeCheckBox() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		boolean actualResult = lp.untickRememberMecheckBox();
		boolean expectedResult = Constant.EXPECTEDRESULTOFREMEMBERMEUNCHECK;
		Assert.assertEquals(actualResult, expectedResult,
				prop.getProperty("ErrorMessageForVerifyTheUncheckOfRememberMeCheckBox"));
	}

	@Test(groups = { "High", "Critical" }, priority = 2, retryAnalyzer = RetryUtils.class)
	public void verifyTheLoginBoxMessage() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		String actualResult = lp.getTheLoginBoxMessage();
		String expectedResult = prop.getProperty("ExpectedResultoftheLoginBoxMessage");
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHELOGINBOXMESSAGE);

	}

}
