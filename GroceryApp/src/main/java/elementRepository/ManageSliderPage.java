package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSliderPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// initialize elements page factory

	}

	@FindBy(xpath = "//p[text()='Manage Slider']")
	WebElement manageSliderTab;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']")
	WebElement newButton;
	@FindBy(id = "main_img")
	WebElement chooseFile;
	@FindBy(xpath = "//input[@id='link']")
	WebElement linkTab;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//a[@href='http://groceryapp.uniqassosiates.com/admin/list-slider?page_ad=1']")
	WebElement pageLink;

	public void clickManageSliderTab() {
		gu.clickButton(manageSliderTab);
	}

	public String getTheCurrentURL() {
		return gu.getTheCurrentURLOFPage(driver);
	}

	public String uploadMattaRiceInManageSliderPage() throws AWTException {
		return gu.addNewSliderInformationForElement(driver, newButton, chooseFile, saveButton, linkTab, "abcd",
				alertMessage);
	}

	public String scrollManageSlidePage() throws InterruptedException {
		gu.clickButton(manageSliderTab);
		return gu.pageScroll(driver, pageLink);
	}

}
