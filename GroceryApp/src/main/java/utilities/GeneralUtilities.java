package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Monitor.Guard;

public class GeneralUtilities {
	ExplicitWait ew = new ExplicitWait();

	public String getTheTextOfElement(WebElement element) {

		String textString = element.getText();
		return textString;
	}

//public String selectValueFromDropDown(WebElement element,String value) {
//	Select select = new Select(element);
//	select.selectByValue(value);
//	WebElement selectedElement = select.getFirstSelectedOption();
//	String text = selectedElement.getText();
//	return text;
//}

	public String getTheStylePropertyValue(WebElement element, String value) {
		String text = element.getCssValue(value);
		return text;
	}

	public void clickButton(WebElement element) {
		element.click();

	}

	public String readTextOfAnElement(WebElement element) {
		String result = element.getText();
		return result;
	}

	public boolean checkWhetherTheElementIsSelected(WebElement element) {
		boolean result = element.isSelected();
		return result;
	}

	public boolean getTheListOfElementsWithSearchValue(List<WebElement> list, WebElement titleBarElement,
			WebElement searchListProductElement, String comparingValue) {
		titleBarElement.sendKeys(comparingValue);
		searchListProductElement.click();
		boolean result = true;
		for (int i = 0; i < list.size(); i++) {
			String textString = list.get(i).getText();
			if (!(textString.contains(comparingValue))) {
				result = false;
			}
		}
		return result;
	}

	public String getTheTagNameOfElement(WebElement element) {
		String tagName = element.getTagName();
		return tagName;
	}

	public boolean checkWhetherTheElementIsSelectedByUsingAtributeValue(WebElement element, String attribute,
			String comparingValue) {
		String result = element.getAttribute(attribute);
		boolean res = result.contains(comparingValue);
		return res;
	}

	public boolean checkWhetherElementIsPresent(WebElement element) {
		boolean result = element.isDisplayed();
		return result;
	}

	public String getTitleOfTheCurrentPage(WebDriver driver) {
		String text = driver.getTitle();
		return text;
	}

	public String selectOptionFromDropDown(WebElement element, String selectByvalue) {
		Select select = new Select(element);
		select.selectByValue(selectByvalue);
		WebElement selectedOption = select.getFirstSelectedOption();
		String option = selectedOption.getText();

		return option;
	}

	public boolean findElementFromListOfElementsAndClickDelete(WebDriver driver, List<WebElement> list,
			WebElement element, WebElement element2, String searchValue, String comparingValue) {
		element.sendKeys(searchValue);
		element2.click();
		String locator = null;
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			if (text.contains(comparingValue)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[9]//a[2]";
				break;
			}
		}
		WebElement deleteButton = driver.findElement(By.xpath(locator));
		boolean result = deleteButton.isDisplayed();

		return result;
	}

	public String addNewSliderInformationForElement(WebDriver driver, WebElement newButtonElement,
			WebElement choosFileButtonElement, WebElement saveButtonElement, WebElement linkBarElement, String value,
			WebElement alertMessage) throws AWTException {
		clickButton(newButtonElement);
//		clickButton(choosFileButtonElement);
		Actions actions = new Actions(driver);
		actions.moveToElement(choosFileButtonElement).click().perform();
		Robot robot = new Robot();
		StringSelection ss = new StringSelection(
				System.getProperty("user.dir") + "\\src\\main\\resources\\UploadImages\\mattarice.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// to press a key need 2 codes keyPress and keyRelease
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		linkBarElement.sendKeys(value);
		clickButton(saveButtonElement);
		String msg = alertMessage.getText();
		return msg;
	}

	public String getTheStatusOfUsers(WebDriver driver, List<WebElement> list, String comparingValue) {
		String locator = null;
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).getText();
			if (name.equals(comparingValue)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[5]";
			}
		}
		WebElement status = driver.findElement(By.xpath(locator));
		String statusText = status.getText();
		return statusText;
	}

	public String getTheCurrentURLOFPage(WebDriver driver) {
		String currentURL = driver.getCurrentUrl();
		return currentURL;

	}

	public boolean addUsersToAdminUsersPage(WebElement username, WebElement pswd, WebElement userType,
			WebElement saveButtonElement, String userNameValue, String pswdValue, String userTypeValue,
			WebElement userNameElement) {
		username.sendKeys(userNameValue);
		pswd.sendKeys(pswdValue);
		selectOptionFromDropDown(userType, userTypeValue);
		clickButton(saveButtonElement);
		boolean a = userNameElement.isDisplayed();
		return a;

	}

	public boolean verificationOfUserAddition(WebDriver driver, List<WebElement> list, WebElement userNameElement,
			WebElement subSearch, String searchValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("un")));
		userNameElement.click();
		userNameElement.sendKeys(searchValue);
		clickButton(subSearch);
		boolean result = false;
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).getText();
			if (name.equals(searchValue)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public void deleteAdminUserFromAdminUsersTab(WebDriver driver, List<WebElement> list, String compareValue) {
		String locator = null;
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).getText();
			if (name.equals(compareValue)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[5]//a[@role='button'][3]";
				break;
			}
		}
		WebElement deleteButton = driver.findElement(By.xpath(locator));
		deleteButton.click();
		driver.switchTo().alert().accept();

	}

	public String pageScroll(WebDriver driver, WebElement pageLink) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;// object creation
		js.executeScript("window.scrollBy(0,1000)");// scroll down,values for horizontal and vertical position
		// Thread.sleep(3000);//to provide delay
		String result = pageLink.getText();
		return result;
	}

	public void onlySelectValueFromDropDown(WebElement element, String selectByValue) {
		Select select = new Select(element);
		select.selectByValue(selectByValue);

	}

	public String changeTheStatusOfOrderId(WebDriver driver, List<WebElement> list, String compareValue) {
		String locator = null;
		for (int i = 0; i < list.size(); i++) {
			String value = list.get(i).getText();
			if (value.equals(compareValue)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[6]//span[@style='text-transform: uppercase;']";
				break;
			}
		}
		WebElement status = driver.findElement(By.xpath(locator));
		String textString = status.getText();
		return textString;
	}

	public String getgetTheStatusOfState(WebDriver driver, List<WebElement> list, String comparingValue) {
		String locator = null;
		for (int i = 0; i < list.size(); i++) {
			String state = list.get(i).getText();
			if (state.equals(comparingValue)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[5]";
				break;
			}
		}
		WebElement stateStatus = driver.findElement(By.xpath(locator));
		String status = stateStatus.getText();
		return status;
	}

	public String getTheDeliveryChargeForState(WebDriver driver, List<WebElement> list, String comparingValue) {
		String locator = null;
		for (int i = 0; i < list.size(); i++) {
			String state = list.get(i).getText();
			if (state.equals(comparingValue)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[4]";
				break;
			}
		}
		WebElement deliveryCharge = driver.findElement(By.xpath(locator));
		String charge = deliveryCharge.getText();
		return charge;
	}

	public void addNewCategoryToExpenseCategoryPage(WebElement expenseCategory, WebElement newButton, WebElement title,
			String expenseCategoryValue, WebElement saveBUtton) {
		clickButton(expenseCategory);
		clickButton(newButton);
		title.sendKeys(expenseCategoryValue);
		clickButton(saveBUtton);
	}

	public boolean verifyTheCategoryAddedToExpenseCategoryPage(List<WebElement> list, String comparingValue) {
		boolean result = false;
		for (int i = 0; i < list.size(); i++) {
			String categoryName = list.get(i).getText();
			if (categoryName.equals(comparingValue)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public void deleteExpenseCategory(WebDriver driver, List<WebElement> list, String comparingValue) {
		String locator = null;
		for (int i = 0; i < list.size(); i++) {
			String titleNameString = list.get(i).getText();
			if (titleNameString.equals(comparingValue)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[2]//i[@class='fas fa-trash-alt']";
				break;
			}
		}
		WebElement deleteButton = driver.findElement(By.xpath(locator));
		deleteButton.click();
		driver.switchTo().alert().accept();
	}

	public String getTheLoginBoxMessage(WebElement text) {
		String message = text.getText();
		return message;
	}

	public int randomnumbers() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		return randomInt;
	}

	public String randomPassword() {
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String num = "0123456789";
		String character = "!@#$%^&*-_=+|;:,<.>/?";
		String combination = upper + lower + num + character;
		int len = 8;
		char[] pwd = new char[8];
		Random r = new Random();
		for (int i = 0; i < len; i++) {
			pwd[i] = combination.charAt(r.nextInt(combination.length()));
		}
		String password = new String(pwd);
		return password;

	}

	public String getTheHeadingOfThePageSelected(WebElement heading) {
		String result= heading.getText();
		return result;
	}

}
