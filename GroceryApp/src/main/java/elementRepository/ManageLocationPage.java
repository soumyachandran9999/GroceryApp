package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocationPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// initialize elements page factory

	}
	
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'])[1]")
	WebElement manageLocationTab;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[3]")
	List<WebElement> stateColumn;
	
	public void clickManageLocationTab() {
		gu.clickButton(manageLocationTab);
	}
	public String getTheStatusOfCornwallStateInManageLocation() {
		return gu.getTheStatusOfUsers(driver, stateColumn, "Cornwall");
	}
	public String getTheDeliveryChargeForDerbyState() {
		
		return gu.getTheDeliveryChargeForState(driver,stateColumn,"Derby");
	}

}
