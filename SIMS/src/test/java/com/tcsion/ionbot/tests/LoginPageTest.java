package com.tcsion.ionbot.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcsion.ionbot.base.TestBase;
import com.tcsion.ionbot.pages.HomePage;
import com.tcsion.ionbot.pages.LoginPage;

public class LoginPageTest extends TestBase {
	//LoginPage loginPage;
	//HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	/*@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}*/
	
	@Test(priority=2)
	public void loginTest() throws Exception
	{
loginPage.login(prop.getProperty("username"),prop.getProperty("password"));	
	}
@Test(priority=1)
public void homeTitle()
{
	//logger=extent.startTest("pass");
	String a=loginPage.validateLoginpageTitle();
	System.out.println(a);
	//logger.log(LogStatus.PASS, "pass");
}
	/*@AfterMethod
	public void tearDown(){
		driver.quit();
	}*/
}
