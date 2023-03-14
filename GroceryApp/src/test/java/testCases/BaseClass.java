package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import utilities.ScreenShotUtility;

public class BaseClass {

	WebDriver driver;
	ScreenShotUtility scr;
	public static Properties prop;// reference variable for object

	public static void testBasic(){
		prop = new Properties();// create object for properties
		FileInputStream ip;
		try {
			ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");
			prop.load(ip);// load method is used to load the file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browserValue) throws IOException {
		testBasic();
		if (browserValue.equals(prop.getProperty("Browser1"))) {
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
		} else if (browserValue.equals(prop.getProperty("Browser2"))) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.get(prop.getProperty("BaseURL"));// getProperty method use to get value from property file

	}
	

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			scr = new ScreenShotUtility();
			scr.captureFailureScreenShot(driver, itestResult.getName());
		}
		driver.close();
	}

}
