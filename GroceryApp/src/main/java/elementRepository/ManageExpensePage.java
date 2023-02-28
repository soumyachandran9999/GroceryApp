package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
	WebElement manageExpense;

	public void clickOnManageExpenseDropDown() {
		gu.clickButton(manageExpenseDropDown);
		//boolean b =manageExpense.getAttribute("class").contains("active");
	}

	public boolean selectManageExpenseButton() {
		gu.clickButton(manageExpense);
		return gu.checkWhetherTheElementIsSelectedByUsingAtributeValue(manageExpense, "class", "active");

	}
	

}
