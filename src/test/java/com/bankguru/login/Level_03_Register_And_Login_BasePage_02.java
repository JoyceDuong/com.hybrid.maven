package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilities.ExcelConfig;
import commons.BasePage;

public class Level_03_Register_And_Login_BasePage_02 {
	WebDriver driver;
	BasePage basepage;
	String projectPath = System.getProperty("user.dir");
	String userID,password,loginPageUrl,email;
	ExcelConfig excel;
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver",projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		excel = new ExcelConfig();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
		driver.manage().window().maximize();
		//Che dấu sự khởi tạo của đối tượng
		basepage = BasePage.getBasePage();
		
	}
	@Test
	public void Login_01_Register() {
		basepage.openPageUrl(driver, "http://demo.guru99.com/v4/");
		loginPageUrl = basepage.getPageUrl(driver);
		basepage.clickToElement(driver, "//a[text()='here']");
		basepage.sendkeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
		basepage.clickToElement(driver, "//input[@name='btnLogin']");
		
	 userID = basepage.getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
	 password = basepage.getElementText(driver, "//td[text()='Password :']/following-sibling::td");
	}
	
	@Test
	public void Login_02_Login() {
		
		basepage.openPageUrl(driver, loginPageUrl);
		basepage.sendkeyToElement(driver, "//input[@name='uid']", userID);
		basepage.sendkeyToElement(driver, "//input[@name='password']", password);
		basepage.clickToElement(driver, "//input[@name='btnLogin']");
		Assert.assertTrue(basepage.isElementDisplayed(driver, "//marquee[@class='heading3' and text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
	}
	public String getRandomEmail() {
		Random rand = new Random();
		
		return "testing" + rand.nextInt(9999) + "@gmail.com";
		
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
}
