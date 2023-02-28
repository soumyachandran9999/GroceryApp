package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminUsersPage;
import elementRepository.LoginPage;

public class AdminUsersPageTestCases extends BaseClass {
	LoginPage lp;
	AdminUsersPage ap;

	@Test
	public void additionOfManavAsAdminUser() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		ap = new AdminUsersPage(driver);
		ap.clickAdminUsersTab();
		String actualResult = ap.addUserAsAdmin();
		String expectedResult = "×\n"+ "Alert!\n"+ "User Created Successfully";
		Assert.assertEquals(actualResult, expectedResult, ":: User Addition is not expected");
	}
	@Test
	public void verifyTheAdditionOfManavAsAdminUser() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		ap = new AdminUsersPage(driver);
		ap.clickAdminUsersTab();
		boolean actualResult = ap.verifyTheAddedAdminUser();
		boolean expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEADDITIONOFMANAVASADMINUSER;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEADDITIONOFMANAVASADMINUSER);
	}
	
	@Test
	public void verifyTheCurrentUrlOfThePage() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		ap = new AdminUsersPage(driver);
		ap.clickAdminUsersTab();
		String actualResult = ap.currentUrlOfThePage();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHECURRENTURLOFTHEPAGE;
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGEOFVERIFYTHECURRENTURLOFTHEPAGE );
	}
	
}
