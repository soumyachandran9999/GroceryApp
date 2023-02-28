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

	@Test
	public void verifyTheTextOnSignInBUtton() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		String actualResultString = lp.getTheTextOfSignInButton();
		String expectedResultString = prop.getProperty("ExpectedResultOfverifyTheTextOnSignInBUtton");
		Assert.assertEquals(actualResultString, expectedResultString, Constant.EXPECTEDRESULTOFVERIFYTEXTOFLOGINBUTTON);
	}

	@Test
	public void verifyTheBrandTextDisplayedInTheLoginPage() {
		lp = new LoginPage(driver);
		String actualResultString = lp.getTheBrandTextInTheLoginPage();
		String expectedResultString = Constant.EXPECTEDRESULTOFBRANDTEXTINLOGINPAGE;
		Assert.assertEquals(actualResultString, expectedResultString, Constant.ERRORMESSAGEOFBRANDNAMEINLOGINPAGE);
	}

	@Test
	public void verifyTheUncheckOfRememberMeCheckBox() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		boolean actualResult = lp.untickRememberMecheckBox();
		boolean expectedResult = Constant.EXPECTEDRESULTOFREMEMBERMEUNCHECK;
		Assert.assertEquals(actualResult, expectedResult, prop.getProperty("ErrorMessageForVerifyTheUncheckOfRememberMeCheckBox"));
	}

}
