package com.tcsion.ionbot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.tcsion.ionbot.base.TestBase;
import com.google.common.io.Files;

//import org.apache.commons.io.FileUtils;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;

	public static String TESTDATA_SHEET_PATH = "H:/Automation"
			+ "/FreeCRMTestAutomation/src/main/java/com/crm/qa/testdata/testdata.xlsx";

	static XSSFWorkbook book;
	static XSSFSheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData() {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = (XSSFWorkbook) WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheetAt(0);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0)
				.getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		Files.copy(
				scrFile,
				new File(currentDir + "/screenshots/"
						+ System.currentTimeMillis() + ".png"));

	}
	
	public static String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		
		File destination=new File(path);
		
		try 
		{
			Files.copy(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		
		return path;
	}

}