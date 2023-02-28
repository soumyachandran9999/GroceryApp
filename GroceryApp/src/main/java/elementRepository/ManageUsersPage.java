package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageUsersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[text()='Manage Users']")
	WebElement manageUsers;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> nameColumn;

	public String getTheStatusOfSadfgDdf() {
		gu.clickButton(manageUsers);
		return gu.getTheStatusOfUsers(driver, nameColumn, "Sadfg Ddf");

	}

}
