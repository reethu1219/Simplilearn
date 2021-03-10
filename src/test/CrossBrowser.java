package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentReports;

public class CrossBrowser {
	
	WebDriver chromeDriver;
	WebDriver firefoxDriver;
	
	@Test
	public void LaunchChrome() throws MalformedURLException {
		//System.setProperty("webdriver.chrome.driver","/home/reethacmtecnotr/Downloads/chromedriver");
		//System.setProperty("webdriver.gecko.driver","/home/reethacmtecnotr/Downloads/geckodriver");
		 
		//extent = new ExtentReports("ExtentReport.html",true);
		

		DesiredCapabilities obj = new DesiredCapabilities();
		
		obj.setPlatform(Platform.LINUX);
		obj.setBrowserName("chrome");
		
		
		String HubURL =  "http://localhost:4444/wd/hub";
		chromeDriver = new RemoteWebDriver(new URL(HubURL),obj);
		
		chromeDriver.get("https://www.simplilearn.com/");
		
		chromeDriver.manage().window().maximize(); 
		chromeDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		chromeDriver.quit();
	
		
	}
	@Test(dependsOnMethods="LaunchChrome")
	public void testcase1() {
		WebElement linkLogin= chromeDriver.findElement(By.linkText("Log in"));
		linkLogin.click();
		
	}
	@Test
	public void Launchfirefox() throws MalformedURLException {
		//System.setProperty("webdriver.chrome.driver","/home/reethacmtecnotr/Downloads/chromedriver");
		//System.setProperty("webdriver.gecko.driver","/home/reethacmtecnotr/Downloads/geckodriver");
		 
		//extent = new ExtentReports("ExtentReport.html",true);
		

		DesiredCapabilities obj = new DesiredCapabilities();
		
		obj.setPlatform(Platform.LINUX);
		obj.setBrowserName("firefox");
		
		
		String HubURL =  "http://localhost:4444/wd/hub";
		firefoxDriver = new RemoteWebDriver(new URL(HubURL),obj);
		
		firefoxDriver.get("https://www.simplilearn.com/");
		
		firefoxDriver.manage().window().maximize(); 
		firefoxDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		firefoxDriver.quit();
	
		
	}
	@Test(dependsOnMethods="Launchfirefox")
	public void testcase2() {
		WebElement linkLogin= firefoxDriver.findElement(By.linkText("Log in"));
		linkLogin.click();
		
	}

}
