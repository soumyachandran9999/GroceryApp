package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;
import utilities.RetryUtils;

public class ManageProductPageTestCases extends BaseClass {

	LoginPage lp;
	ManageProductPage mp;

	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheBackgroundColorOfNewButton() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		String actalResult = mp.getTheBackgroundColorOfNewButton();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEBACKGROUNDCOLOROFNEWBUTTON;
		Assert.assertEquals(actalResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEBACKGROUNDCOLOROFNEWBUTTON);

	}
	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheBackgroundColorOfSearchButton() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		String actalResult = mp.getTheBackgroundColorOfSearchButton();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEBACKGROUNDCOLOROFSEARCHBUTTON;
		Assert.assertEquals(actalResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEBACKGROUNDCOLOROFSEARCHBUTTON);

	}
	
	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheBackgroundColorOfResetButton() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		String actalResult = mp.getTheBackgroundColorOfResetButton();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEBACKGROUNDCOLOROFRESETBUTTON;
		Assert.assertEquals(actalResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEBACKGROUNDCOLOROFRESETBUTTON);

	}
	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheFontColorOfResetButton() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		String actalResult = mp.getTheFontColorOfResetButton();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEFONTCOLOROFRESETBUTTON;
		Assert.assertEquals(actalResult, expectedResult,Constant.ERRORMESSAGEOFVERIFYTHEFONTCOLOROFRESETBUTTON );

	}
	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheBorderColorOfNewButton() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		String actalResult = mp.getTheBorderColorOfNewButton();
		String expectedResult = Constant.EXPECTEDRESULTOFTHEBORDERCOLOROFNEWBUTTON;
		Assert.assertEquals(actalResult, expectedResult, Constant.ERRORMESSAGEOFTHEBORDERCOLOROFNEWBUTTON);

	}
	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheListedItemsInTheTitleColumnUnderRedMeatSearch() throws IOException {
		testBasic();
		lp=new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mp=new ManageProductPage(driver);
		mp.clickManageProduct();
		mp.clickSearchButton();
		boolean actualResult= mp.getTheListOfItemsWithTitleValueRedMeat();
		boolean expectedResult=true;
		Assert.assertEquals(actualResult, expectedResult, "::Listed items in the Title Column is not Expected");
		
	}
//	@Test
//	public void verifyTheSelectedValueInTheCategoryTab() throws IOException {
//		testBasic();
//		lp=new LoginPage(driver);
//		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
//		mp=new ManageProductPage(driver);
//		mp.clickManageProduct();
//		mp.clickSearchButton();
//		String actualResult= mp.selectCategoryOfListProducts();
//		String expectedResult=prop.getProperty("ExpectedResultOfVerifyTheSelectedValueInTheCategoryTab");
//		Assert.assertEquals(actualResult, expectedResult, prop.getProperty("ErrorMessageOfVerifyTheSelectedValueInTheCategoryTab"));
//		
//	}
	
	@Test(groups = { "Regression" },retryAnalyzer = RetryUtils.class)
	public void verifyTheAlertTextAfterClickingDeleteButtonCorrespondingToParachuteCoconutOil() throws IOException {
		testBasic();
		lp=new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mp=new ManageProductPage(driver);
		mp.clickManageProduct();
		mp.clickSearchButton();
		boolean actualResult= mp.findParachuteFromTheListOfItemsWithTitleValueCoconutOilAndDelete();
		boolean expectedResult=true;
		Assert.assertEquals(actualResult, expectedResult,prop.getProperty("ErrorMessageOfVerifyTheAlertTextAfterClickingDeleteButtonCorrespondingToParachuteCoconutOil") );
		
	}
}
