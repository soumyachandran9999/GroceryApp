package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import dataProvider.DataProviderByExcel;
import elementRepository.AdminUsersPage;
import elementRepository.LoginPage;
import utilities.RetryUtils;

public class AdminUsersPageTestCases extends BaseClass {
	LoginPage lp;
	AdminUsersPage ap;

	@Test(groups = { "Smoke" }, priority = 1, retryAnalyzer = RetryUtils.class)
	public void additionOfManavAsAdminUser() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.clickAdminUsersTab();
		boolean actualResult = ap.addUserAsAdmin();
		boolean expectedResult = Constant.EXPECTEDRESULTOFADDITIONOFMANAVASADMINUSER;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFADDITIONOFMANAVASADMINUSER);
		
	}

	@Test(groups = { "Sanity" }, priority = 2, retryAnalyzer = RetryUtils.class)
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

	@Test(groups = { "Regression" }, priority = 2, retryAnalyzer = RetryUtils.class)
	public void verifyTheCurrentUrlOfThePage() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.clickAdminUsersTab();
		String actualResult = ap.currentUrlOfThePage();
		String expectedResult = prop.getProperty("ExpectedResultOfverifyTheCurrentUrlOfThePage");
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHECURRENTURLOFTHEPAGE);
	}

	@Test(dataProvider = "create_user_data",dataProviderClass = DataProviderByExcel.class, groups = { "Regression" }, priority = 2, retryAnalyzer = RetryUtils.class)
	public void verifyTheAdditionOfUsersUsingRandomDataGeneration(String name, String pswd, String userType) {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.clickAdminUsersTab();
		boolean actualResult = ap.addUsersUsingRandomDataGeneration(name, pswd, userType);
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHECURRENTURLOFTHEPAGE);
	}

	

}
