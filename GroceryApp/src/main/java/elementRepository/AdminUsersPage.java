package elementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;
public class AdminUsersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew= new ExplicitWait();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// initialize elements page factory

	}

	@FindBy(xpath = "//p[text()='Admin Users']")
	WebElement adminUsersTab;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "user_type")
	WebElement userType;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']//i[@class='fa fa-save']")
	WebElement saveButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(id = "un")
	WebElement userNameUnderSearch;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement subSearchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> userNameColumn;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//thead//th[1]")
	WebElement userNameElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;

	public void clickAdminUsersTab() {
		gu.clickButton(adminUsersTab);
	}

	public boolean addUserAsAdmin() {
		ew.waitTillPresenceOfElement(driver, "//a[@class='btn btn-rounded btn-danger']");
		gu.clickButton(newButton);
		return gu.addUsersToAdminUsersPage(userName, password, userType, saveButton, "Manav", "asdf", "admin",
				userNameElement);

	}

	public boolean verifyTheAddedAdminUser() {
		gu.clickButton(searchButton);
		return gu.verificationOfUserAddition(driver, userNameColumn, userNameUnderSearch, subSearchButton, "Manav");
	}

	public String currentUrlOfThePage() {
		return gu.getTheCurrentURLOFPage(driver);
	}

	public void deleteAdminUser() {
		gu.deleteAdminUserFromAdminUsersTab(driver, userNameColumn, "Manav");
	}
	public String addUsersUsingRandomDataGeneration() {
		
		return null;
		
	}

}


