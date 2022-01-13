package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utilities.ExcelConfig;
import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Level_16_Get_Excel_Data {
	WebDriver driver;
	ExcelConfig excel;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		excel = new ExcelConfig();

	}

	@Test
	public void f() throws Exception {

		excel.setExcelFile(GlobalConstants.EXCEL_PATH, "Sheet1");

		String user = excel.getCellData(1, 1);

		System.out.println(" Excel Path : " + GlobalConstants.EXCEL_PATH);
		System.out.println(" user name : " + user);
	}

	@AfterClass
	public void afterClass() {
	}

}