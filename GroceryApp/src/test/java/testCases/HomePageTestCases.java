package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.RetryUtils;

public class HomePageTestCases extends BaseClass {
	LoginPage lp;
	HomePage hp;

	@Test(groups = { "Regression" }, retryAnalyzer = RetryUtils.class)
	public void verifyThePresenceOfBrandText() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		hp = new HomePage(driver);
		boolean actaualResult = hp.checkWhetherTheBrandTextIsPresent();
		boolean expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEPRESENCEOFBRANDTEXT;
		Assert.assertEquals(actaualResult, expectedResult, Constant.ERRORMESSAGEBRANDTEXT);

	}

	@Test(groups = { "Regression" }, retryAnalyzer = RetryUtils.class)
	public void verifyTheLogOutOfUserFromTheApplication() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		hp = new HomePage(driver);
		boolean actualResult = hp.logoutFromTheApplication();
		boolean expectedResult = Constant.EXPECTEDRESULTOFSUCCESSFULLOGOUT;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGELOGOUT);

	}
}
