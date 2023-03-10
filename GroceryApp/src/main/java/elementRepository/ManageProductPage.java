package elementRepository;

import java.util.List;

import javax.sound.midi.VoiceStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// initialize elements page factory

	}

	@FindBy(xpath = "//p[text()='Manage Product']")
	WebElement manageProduct;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement titleBar;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> titleColumn;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchListProduct;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryTab;

	public void clickManageProduct() {
		manageProduct.click();

	}

	public String getTheBackgroundColorOfNewButton() {

		return gu.getTheStylePropertyValue(newButton, "background-color");
	}

	public String getTheBackgroundColorOfSearchButton() {
		return gu.getTheStylePropertyValue(searchButton, "background-color");
	}

	public String getTheBackgroundColorOfResetButton() {
		return gu.getTheStylePropertyValue(resetButton, "background-color");
	}

	public String getTheFontColorOfResetButton() {
		return gu.getTheStylePropertyValue(resetButton, "color");
	}

	public String getTheBorderColorOfNewButton() {
		return gu.getTheStylePropertyValue(newButton, "border-color");
	}

	public boolean getTheListOfItemsWithTitleValueRedMeat() {
		return gu.getTheListOfElementsWithSearchValue(titleColumn, titleBar, searchListProduct, "Red Meat");
		
	}

	public void clickSearchButton() {
		gu.clickButton(searchButton);

	}

	public String selectCategoryOfListProducts() {
		return gu.selectOptionFromDropDown(categoryTab, "3");
	}

	public boolean findParachuteFromTheListOfItemsWithTitleValueCoconutOilAndDelete() {
		return gu.findElementFromListOfElementsAndClickDelete(driver, titleColumn, titleBar, searchListProduct, "Coconut Oil", "Parachute");
		
	}
}
