package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageOrderPage;
import utilities.ExcelRead;

public class ManageOrderPageTestCases extends BaseClass {
	LoginPage lp;
	ManageOrderPage mop;

	@Test
	public void verifyTheStatusOfOrderId295() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.signInToTheApplication(prop.getProperty("UserName"), prop.getProperty("Password"));
		mop = new ManageOrderPage(driver);
		mop.clickManageOrderMoreInfo();
		String actualResult = mop.changeTheStatusOfOrderId295();
		String expectedResult = prop.getProperty("ExpectedResultOfVerifyTheStatusOfOrderId295");
		Assert.assertEquals(actualResult, expectedResult,
				prop.getProperty("ErrorMessageOfVerifyTheStatusOfOrderId295"));
	}

}
