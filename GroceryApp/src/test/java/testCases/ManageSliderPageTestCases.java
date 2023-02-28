package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;

public class ManageSliderPageTestCases extends BaseClass {
	LoginPage lp;
	ManageSliderPage msp;

	@Test
	public void verifyTheCurrentPageURL() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		msp = new ManageSliderPage(driver);
		msp.clickManageSliderTab();
		String actualResult = msp.getTheCurrentURL();
		String expectedResult = prop.getProperty("ExpectedResultOfVerifyTheCurrentPageURL");
		Assert.assertEquals(actualResult, expectedResult, prop.getProperty("ErrorMessageOfVerifyTheCurrentPageURL"));
	}

	@Test
	public void addNewSliderInformationForMattaRice() throws IOException, AWTException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		msp = new ManageSliderPage(driver);
		msp.clickManageSliderTab();
		String actualResult = msp.uploadMattaRiceInManageSliderPage();
		//actualResult=actualResult.replaceAll("[^a-zA-Z0-9"]," ");
		String expectedResult = Constant.EXPECTEDRESULTOFADDNEWSLIDERINFORMATIONFORMATTARICE;
		Assert.assertEquals(actualResult, expectedResult, prop.getProperty("ErrorMessageOfAddNewSliderInformationForMattaRice"));
	}
	
	@Test
	public void scrollManageSlidePage() throws IOException, InterruptedException  {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		msp = new ManageSliderPage(driver);
		msp.clickManageSliderTab();
		String actualResult = msp.scrollManageSlidePage();
		String expectedResult =prop.getProperty("ExpectedResultOfScrollManageSlidePage");
		Assert.assertEquals(actualResult, expectedResult, prop.getProperty("ErrorMessageOfScrollManageSlidePage"));
	}

}
