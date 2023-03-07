package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTestCases extends BaseClass {
	LoginPage lp;
	HomePage hp;

	@Test
	public void verifyThePresenceOfBrandText() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		hp = new HomePage(driver);
		boolean actaualResult = hp.checkWhetherTheBrandTextIsPresent();
		boolean expectedResult = true;
		Assert.assertEquals(actaualResult, expectedResult, Constant.ERRORMESSAGEBRANDTEXT);

	}
	
	@Test
	public void verifyTheLogOutOfUserFromTheApplication() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		hp = new HomePage(driver);
		String actualResult=hp.logoutFromTheApplication();
		String expectedResult=Constant.EXPECTEDRESULTOFSUCCESSFULLOGOUT;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGELOGOUT);
		

	}
}
