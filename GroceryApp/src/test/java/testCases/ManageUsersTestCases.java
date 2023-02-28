package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageUsersPage;

public class ManageUsersTestCases extends BaseClass{
	LoginPage lp;
	ManageUsersPage mup;
  @Test
  public void verifyTheStatusOfTester003() {
	  lp=new LoginPage(driver);
	  lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
	  mup=new ManageUsersPage(driver);
	  String actualResult= mup.getTheStatusOfSadfgDdf();
	  String expectedResult=Constant.EXPECTEDRESULTOFVERIFYTHESTATUSORTESTER003;
	  Assert.assertEquals(actualResult, expectedResult, Constant.ERRPRMESSAGEOFVERIFYTHESTATUSORTESTER003);
  }
}
