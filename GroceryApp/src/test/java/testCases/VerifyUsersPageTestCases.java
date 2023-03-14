package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.VerifyUsersPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class VerifyUsersPageTestCases extends BaseClass {
	LoginPage lp;
	VerifyUsersPage vp;
	ExcelRead er;

	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheTagNameofVerifyUsersTab() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		vp = new VerifyUsersPage(driver);
		String actualResult = vp.getTheTagNameOfVerifyUsersTab();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHETAGNAMEOFVERIFYUSERSTAB;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEFORVERIFYTHETAGNAMEOFVERIFYUSERSTAB);

	}

	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheStatusActiveForSearchListUsers() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		vp = new VerifyUsersPage(driver);
		String actualResult = vp.selectStatusActiveForSearchListUsersInVerifyUsersTab();
		er = new ExcelRead();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHESTATUSACTIVEFORSEARCHLISTUSER;
		Assert.assertEquals(actualResult, expectedResult,
				Constant.ERRORMESSAGEOFVERIFYTHESTATUSACTIVEFORSEARCHLISTUSER);

	}
}
