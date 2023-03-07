package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// initialize elements page factory

	}

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInButton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement brandTextInLoginPage;
	@FindBy(xpath = "//label[@for='remember']")
	WebElement rememberMeCheckBox;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement loginBoxMessage;

	public String getTheTextOfSignInButton() {

		return gu.getTheTextOfElement(signInButton);
	}

	public void signInToTheApplication(String name, String pswd) {
		userName.sendKeys(name);
		password.sendKeys(pswd);
		gu.clickButton(signInButton);
	}

	public String getTheBrandTextInTheLoginPage() {
		return gu.readTextOfAnElement(brandTextInLoginPage);
	}

	public boolean untickRememberMecheckBox() {
		gu.clickButton(rememberMeCheckBox);
		return gu.checkWhetherTheElementIsSelected(rememberMeCheckBox);
	}

	public String getTheLoginBoxMessage() {
		return gu.getTheLoginBoxMessage(loginBoxMessage);
	}

}
