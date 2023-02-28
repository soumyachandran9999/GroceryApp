package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManagePaymentMethodPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManagePaymentMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// initialize elements page factory

	}
	@FindBy(xpath = "//p[text()='Manage Payment Methods']")
	WebElement managePaymentMethodsElement;
	
	public void clickManagePaymentMethodsTab() {
		gu.clickButton(managePaymentMethodsElement);
	}
	
	public String getTitleOfManagePaymentMEthodsPage() {
		
		return gu.getTitleOfTheCurrentPage(driver);
	}

}
