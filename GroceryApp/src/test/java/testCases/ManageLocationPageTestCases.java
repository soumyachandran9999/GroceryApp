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
  public void verifyTheStatusOfCornwallState() {
	  lp=new LoginPage(driver);
	  lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
	  mlp=new ManageLocationPage(driver);
	  mlp.clickManageLocationTab();
	  String actualResult= mlp.getTheStatusOfCornwallStateInManageLocation();
	  String expectedResult=Constant.EXPECTEDRESULTOFVERIFYTHESTATUSOFCORNWALLSTATE;
	  Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHESTATUSOFCORNWALLSTATE);
  }
  
  @Test
  public void verifyTheDeliveryChargeForDerbyState() throws IOException {
	  lp=new LoginPage(driver);
	  lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
	  mlp=new ManageLocationPage(driver);
	  mlp.clickManageLocationTab();
	  String actualResult= mlp.getTheDeliveryChargeForDerbyState();
	  actualResult=actualResult.replaceAll("[^a-zA-Z0-9]"," ");
	  String expectedResult=Constant.EXPECTEDRESULTOFVERIFYTHEDELIVERYCHARGEOFDERBYSTATE;
	  Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEOFVERIFYTHEDELIVERYCHARGEOFDERBYSTATE);
  }
}
