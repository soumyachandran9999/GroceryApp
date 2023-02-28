package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.VerifyUsersPage;
import utilities.ExcelRead;

public class VerifyUsersPageTestCases extends BaseClass {
	LoginPage lp;
	VerifyUsersPage vp;
	ExcelRead er;

	@Test
	public void verifyTheTagNameofVerifyUsersTab() {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		vp = new VerifyUsersPage(driver);
		String actualResult = vp.getTheTagNameOfVerifyUsersTab();
		String expectedResult = Constant.EXPECTEDRESULTOFVERIFYTHETAGNAMEOFVERIFYUSERSTAB;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGEFORVERIFYTHETAGNAMEOFVERIFYUSERSTAB );

	}

	@Test
	public void verifyTheStatusActiveForSearchListUsers() throws IOException {
		lp = new LoginPage(driver);
		lp.signInToTheApplication(Constant.USERNAME, Constant.PASSWORD);
		vp = new VerifyUsersPage(driver);
		String actualResult = vp.selectStatusActiveForSearchListUsersInVerifyUsersTab();
		er=new ExcelRead();
		System.out.println(er.readFromExcelFile(0,0));
		String expectedResult=er.readFromExcelFile(0,0);
		Assert.assertEquals(actualResult, expectedResult, er.readFromExcelFile(3, 1));

	}
}
