package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	WebElement brandText;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement logedUserAdmin;
	@FindBy(xpath = "//a[@class='dropdown-item']//i[@class='ace-icon fa fa-power-off']")
	WebElement logOutButton;

	public boolean checkWhetherTheBrandTextIsPresent() {
		return gu.checkWhetherElementIsPresent(brandText);

	}

	public String logoutFromTheApplication() {
		gu.clickButton(logedUserAdmin);
		gu.clickButton(logOutButton);
		return gu.getTitleOfTheCurrentPage(driver);

	}

}
