package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.ExcelConfig;
import commons.BaseTest;
import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Level_14_Register_And_Login_Excel_Data extends BaseTest {
	WebDriver driver;
	ExcelConfig excel;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		excel = new ExcelConfig();

		// excel = new ExcelConfig();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
//		driver.manage().window().maximize();
//		driver.get("http://demo.guru99.com/v4/");
//		loginPageUrl = driver.getCurrentUrl();
	}

	@Test
	public void Login_01_Login() throws Exception {

		excel.setExcelFile(
				"F:\\01-Learn Automation Tesing\\03 - Hybrid Framework\\hybrid-framework-bank\\testdata\\UserInfor.xlsx",
				"Sheet1");
		//System.out.println(GlobalConstants.EXCEL_PATH);

		String user = excel.getCellData(1, 1);
		System.out.println(" User là : " + user);

		String pass = excel.getCellData(2, 1);
		System.out.println("password là : " + pass);

//		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(excel.getCellData("UserName", 0));
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(excel.getCellData("Password", 1));

//		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(excel.getCellData(1 , 0));
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(excel.getCellData(1, 1));

		//driver.findElement(By.name("btnLogin")).click();

	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
}
