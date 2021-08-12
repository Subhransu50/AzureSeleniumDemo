package com.tcsion.ionbot.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;
import com.tcsion.ionbot.ExtentReportListener.ExtentReporterNG;
import com.tcsion.ionbot.pages.LoginPage;
import com.tcsion.ionbot.util.TestUtil;
import com.tcsion.ionbot.util.WebEventListener;

public class TestBase extends ExtentReporterNG {
public static LoginPage loginPage;
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	 ExtentReports extent;
	 ExtentTest logger;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("H://selenium//SIMS//src//main//java//com//tcsion//ionbot//config//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String bname = prop.getProperty("browser");
		if (bname.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\SeleniumServer\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (bname.equals("FireFox")) {
			driver = new FirefoxDriver();

		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	/*@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}*/
	@BeforeMethod
	public LoginPage setUp(){
		initialization();
		loginPage = new LoginPage();
		
		// logger=extent.startTest("ok");
		
		 ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation2.html");
		    extent = new ExtentReports(); 
		 extent.attachReporter(reporter);   
		   logger=extent.createTest("LoginTest");
		
		
		return loginPage;	
	}
/*
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		driver.quit();
	}
	*/
	@AfterMethod
	public void tearDown1(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			String temp=TestUtil.getScreenshot(driver);
			
			//logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		extent.flush();
		driver.quit();
		
	}
}
