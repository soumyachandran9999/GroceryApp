package elementRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class VerifyUsersPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public VerifyUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// initialize elements page factory

	}

	@FindBy(xpath = "//p[text()='Verify Users']")
	WebElement verifyUsersTab;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement statusDropDown;

	public String getTheTagNameOfVerifyUsersTab() {

		return gu.getTheTagNameOfElement(verifyUsersTab);
	}

	public String selectStatusActiveForSearchListUsersInVerifyUsersTab() {
		gu.clickButton(verifyUsersTab);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@onclick='click_button(2)']")));
		gu.clickButton(searchButton);
		return gu.selectOptionFromDropDown(statusDropDown, "active");

	}

}
