package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageOrderPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// initialize elements page factory

	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement manageOrderMoreInfo;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> orderIdColumn;
	@FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
	WebElement changeStatusButton;
	@FindBy(xpath = "//select[@id='status']")
	WebElement selectDropDown;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[3]//td[6]//a[@class='btn btn-primary btn-sm']")
	WebElement changeDeliveryDatElement;
	@FindBy(xpath = "(//input[@class='jquery-datepicker__input datepicker1'])[1]")
	WebElement deliveryDatElement;
	
	public void clickManageOrderMoreInfo() {
		gu.clickButton(manageOrderMoreInfo);
	}
	
	public String changeTheStatusOfOrderId295() {
		return gu.changeTheStatusOfOrderId(driver, orderIdColumn, "295");
	}
	

}
