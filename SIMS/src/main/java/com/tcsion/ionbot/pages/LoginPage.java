package com.tcsion.ionbot.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcsion.ionbot.base.TestBase;
public class LoginPage extends TestBase {

	
	
	public static String TESTDATA_SHEET_PATH = "H:/Automation"
			+ "/SIMS/src/main/java/com/tcs/sims/testdata/testdata.xlsx";
	
	@FindBy(name="accountname")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="html/body/div[3]/div[3]/div[1]/form/div[6]/a[2]")
	WebElement loginBtn;
	
	@FindBy(xpath="button[contains(text(),'Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath=".//*[@id='username']")
	WebElement dualuname;
	
	@FindBy(xpath=".//*[@id='password']")
	WebElement dualpassword;
	
	@FindBy(xpath=".//*[@id='login_btn']")
	WebElement duallogin;
	
	@FindBy(xpath="html/body/div[2]/div[3]/div/button")
	WebElement alert;
	
	@FindBy(xpath=".//*[@id='start']")
	WebElement webtop;
	
	@FindBy(xpath=".//*[@id='id56']")
	WebElement sims1;
	
	@FindBy(xpath=".//*[@id='window_applications_content']")
	WebElement sims2;
	
	@FindBy(xpath=".//*[@id='quicklauncher']/div/a[2]")
	WebElement forward;
	
	@FindBy(xpath="//*[@id='idc']//img")
	WebElement sims;
	
	@FindBy(xpath="//h1[@class='organization-name']")
	WebElement ok;
	
	/*@FindBy(xpath="//li[@id='9516']//a[@id='ida']//img")
	WebElement simsfinancialreport;*/
	
	@FindBy(xpath="//*[@id='9516']")
	WebElement simsfinancialreport;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginpageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	/*public HomePage login(String ur,String pwd,String dunm,String dpwd) throws Exception
	{Thread.sleep(5000);
		username.sendKeys(ur);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		loginBtn.click();
		
		Thread.sleep(40000);
		dualuname.sendKeys(dunm);
		dualpassword.sendKeys(dpwd);
		duallogin.click();
		
		
		Thread.sleep(40000);
		alert.click();
		Thread.sleep(5000);
		
	System.out.println("A");
	driver.findElement(By.name("accountname")).sendKeys("admin.tcssupport@greatlakes.com");
	System.out.println("B");
	Thread.sleep(5000);
	driver.findElement(By.name("password")).sendKeys("widowwh!te");
	System.out.println("C");
	Thread.sleep(5000);
	driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/form/div[6]/a[2]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("dunm");
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("dpwd");
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='login_btn']")).click();
	Thread.sleep(5000);
	
		return new HomePage();
	}
	
	*/
	public HomePage login(String ur,String pwd) throws Exception
	{Thread.sleep(5000);
		username.sendKeys(ur);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		loginBtn.click();
		
		Thread.sleep(4000);
		/*dualuname.sendKeys(dunm);
		dualpassword.sendKeys(dpwd);*/
		//duallogin.click();
		//WebDriverWait wait = new WebDriverWait(driver,30);

		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ok.isDisplayed()));
		
		
		//Thread.sleep(40000);
		//alert.click();
		//Thread.sleep(5000);
		
	/*System.out.println("A");
	driver.findElement(By.name("accountname")).sendKeys("admin.tcssupport@greatlakes.com");
	System.out.println("B");
	Thread.sleep(5000);
	driver.findElement(By.name("password")).sendKeys("widowwh!te");
	System.out.println("C");
	Thread.sleep(5000);
	driver.findElement(By.xpath("html/body/div[3]/div[3]/div[1]/form/div[6]/a[2]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("dunm");
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("dpwd");
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='login_btn']")).click();
	Thread.sleep(5000);*/
	
		return new HomePage();
	}
	
}
