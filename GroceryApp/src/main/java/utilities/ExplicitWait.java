package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	public void waitTillPresenceOfElement(WebDriver driver, String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		
	}
	public void waitTillPresenceOfAlert(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public void waitTillElementToBeClickable(WebDriver driver,String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		
	}
	public void waitTillElementToBeSelected(WebDriver driver,String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath(locator)));
		
	}
	public void waitTillElementToBeSelected(WebDriver driver,String locator,String attributeType,String attributeValue) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.attributeToBe(By.xpath(locator), attributeType, attributeValue));
		
	}

}
