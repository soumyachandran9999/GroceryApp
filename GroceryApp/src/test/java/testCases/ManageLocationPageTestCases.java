package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageLocationPage;
import utilities.ExcelRead;

public class ManageLocationPageTestCases extends BaseClass {
	LoginPage lp;
	ManageLocationPage mlp;
	ExcelRead er;

	@Test
	public void verifyTheStatusOfCornwallState() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mlp = new ManageLocationPage(driver);
		mlp.clickManageLocationTab();
		String actualResult = mlp.getTheStatusOfCornwallStateInManageLocation();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHESTATUSOFCORNWALLSTATE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHESTATUSOFCORNWALLSTATE);
	}

	@Test
	public void verifyTheDeliveryChargeForDerbyState() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mlp = new ManageLocationPage(driver);
		mlp.clickManageLocationTab();
		String actualResult = mlp.getTheDeliveryChargeForDerbyState();
		actualResult = actualResult.replaceAll("[^a-zA-Z0-9]", " ");
		er = new ExcelRead();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEDELIVERYCHARGEOFDERBYSTATE;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEDELIVERYCHARGEFORDERBYSTATE);
	}
}
