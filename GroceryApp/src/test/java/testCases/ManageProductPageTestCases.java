package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class ManageProductPageTestCases extends BaseClass {

	LoginPage lp;
	ManageProductPage mp;

	@Test
	public void verifyTheBackgroundColorOfNewButton() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		String actalResult = mp.getTheBackgroundColorOfNewButton();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEBACKGROUNDCOLOROFNEWBUTTON;
		Assert.assertEquals(actalResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEBACKGROUNDCOLOROFNEWBUTTON);

	}
	@Test
	public void verifyTheBackgroundColorOfSearchButton() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		String actalResult = mp.getTheBackgroundColorOfSearchButton();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEBACKGROUNDCOLOROFSEARCHBUTTON;
		Assert.assertEquals(actalResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEBACKGROUNDCOLOROFSEARCHBUTTON);

	}
	
	@Test
	public void verifyTheBackgroundColorOfResetButton() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		String actalResult = mp.getTheBackgroundColorOfResetButton();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEBACKGROUNDCOLOROFRESETBUTTON;
		Assert.assertEquals(actalResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEBACKGROUNDCOLOROFRESETBUTTON);

	}
	@Test
	public void verifyTheFontColorOfResetButton() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		String actalResult = mp.getTheFontColorOfResetButton();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHEFONTCOLOROFRESETBUTTON;
		Assert.assertEquals(actalResult, expectedResult,Constant.ERRORMESSAGEOFVERIFYTHEFONTCOLOROFRESETBUTTON );

	}
	@Test
	public void verifyTheBorderColorOfNewButton() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		String actalResult = mp.getTheBorderColorOfNewButton();
		String expectedResult = Constant.EXPECTEDRESULTOFTHEBORDERCOLOROFNEWBUTTON;
		Assert.assertEquals(actalResult, expectedResult, Constant.ERRORMESSAGEOFTHEBORDERCOLOROFNEWBUTTON);

	}
	@Test
	public void verifyTheListedItemsInTheTitleColumnUnderRedMeatSearch() {
		lp=new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		mp=new ManageProductPage(driver);
		mp.clickManageProduct();
		mp.clickSearchButton();
		boolean actualResult= mp.getTheListOfItemsWithTitleValueRedMeat();
		boolean expectedResult=true;
		Assert.assertEquals(actualResult, expectedResult, "::Listed items in the Title Column is not Expected");
		
	}
	@Test
	public void verifyTheSelectedValueInTheCategoryTab() throws IOException {
		testBasic();
		lp=new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		mp=new ManageProductPage(driver);
		mp.clickManageProduct();
		mp.clickSearchButton();
		String actualResult= mp.selectCategoryOfListProducts();
		String expectedResult=prop.getProperty("ExpectedResultOfVerifyTheSelectedValueInTheCategoryTab");
		Assert.assertEquals(actualResult, expectedResult, prop.getProperty("ErrorMessageOfVerifyTheSelectedValueInTheCategoryTab"));
		
	}
	
	@Test
	public void verifyTheAlertTextAfterClickingDeleteButtonCorrespondingToParachuteCoconutOil() {
		lp=new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		mp=new ManageProductPage(driver);
		mp.clickManageProduct();
		mp.clickSearchButton();
		String actualResult= mp.findParachuteFromTheListOfItemsWithTitleValueCoconutOilAndDelete();
		String expectedResult=prop.getProperty("ExpectedResultOfVerifyTheAlertTextAfterClickingDeleteButtonCorrespondingToParachuteCoconutOil");
		Assert.assertEquals(actualResult, expectedResult,prop.getProperty("ErrorMessageOfVerifyTheAlertTextAfterClickingDeleteButtonCorrespondingToParachuteCoconutOil") );
		
	}
}
