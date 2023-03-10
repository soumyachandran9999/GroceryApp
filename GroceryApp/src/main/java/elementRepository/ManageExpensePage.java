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

import utilities.GeneralUtilities;

public class ManageExpensePage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// initialize elements page factory

	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement manageExpenseDropDown;
	@FindBy(xpath = "//p[text()='Manage Expense']")
	WebElement manageExpense;
	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement expenseCategory;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(id = "name")
	WebElement titleBar;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> titleColumn;
	@FindBy(xpath = "(//h4[@class='card-title'])[2]")
	WebElement headingElement;

	public void clickOnManageExpenseDropDown() {
		gu.clickButton(manageExpenseDropDown);

	}

	public void clickOnExpenseCategory() {
		gu.clickButton(expenseCategory);

	}

	public String selectManageExpenseButton() {
		gu.clickButton(manageExpense);
		return gu.getTheHeadingOfThePageSelected(headingElement);

	}

	public void addNewExpenseCategory(String value) {
		gu.addNewCategoryToExpenseCategoryPage(expenseCategory, newButton, titleBar, value, saveButton);
	}

	public boolean verifyTheAddedCategory(String value) {
		return gu.verifyTheCategoryAddedToExpenseCategoryPage(titleColumn, value);
	}

	public void deleteTheExpenseCategory(String value) {
		gu.deleteExpenseCategory(driver, titleColumn, value);
	}

}
