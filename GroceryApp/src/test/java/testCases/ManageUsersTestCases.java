package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageUsersPage;
import utilities.RetryUtils;

public class ManageUsersTestCases extends BaseClass {
	LoginPage lp;
	ManageUsersPage mup;

	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheStatusOfSadfgDdf() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mup = new ManageUsersPage(driver);
		String actualResult = mup.getTheStatusOfSadfgDdf();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHESTATUSORTESTER003;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRPRMESSAGEOFVERIFYTHESTATUSORTESTER003);
	}
}
