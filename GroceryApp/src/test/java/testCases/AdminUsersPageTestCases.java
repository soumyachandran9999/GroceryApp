package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminUsersPage;
import elementRepository.LoginPage;

public class AdminUsersPageTestCases extends BaseClass {
	LoginPage lp;
	AdminUsersPage ap;

	@Test(groups ={"High"},priority = 1)
	public void additionOfManavAsAdminUser() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.clickAdminUsersTab();
		String actualResult = ap.addUserAsAdmin();
		String expectedResult = "×\n"+ "Alert!\n"+ "User Created Successfully";
		Assert.assertEquals(actualResult, expectedResult, ":: User Addition is not expected");
	}
	@Test(groups = {"Critical"},priority = 2)
	public void verifyTheAdditionOfManavAsAdminUser() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.clickAdminUsersTab();
		boolean actualResult = ap.verifyTheAddedAdminUser();
		boolean expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEADDITIONOFMANAVASADMINUSER;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEADDITIONOFMANAVASADMINUSER);
		ap.deleteAdminUser();
	}
	
	@Test
	public void verifyTheCurrentUrlOfThePage() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.clickAdminUsersTab();
		String actualResult = ap.currentUrlOfThePage();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHECURRENTURLOFTHEPAGE;
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGEOFVERIFYTHECURRENTURLOFTHEPAGE );
	}
	
}
