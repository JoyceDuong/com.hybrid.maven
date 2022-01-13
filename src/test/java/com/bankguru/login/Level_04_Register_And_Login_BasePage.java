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

import commons.BasePage;

public class Level_04_Register_And_Login_BasePage extends BasePage {
	WebDriver driver;
	
	String projectPath = System.getProperty("user.dir");
	String userID,password,loginPageUrl,email;
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver",projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
		driver.manage().window().maximize();
		
		
	}
	@Test
	public void Login_01_Register() {
		openPageUrl(driver, "http://demo.guru99.com/v4/");
		loginPageUrl = getPageUrl(driver);
		clickToElement(driver, "//a[text()='here']");
		sendkeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
		clickToElement(driver, "//input[@name='btnLogin']");
		
	 userID = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
	 password = getElementText(driver, "//td[text()='Password :']/following-sibling::td");
	}
	
	@Test
	public void Login_02_Login() {
		
		openPageUrl(driver, loginPageUrl);
		sendkeyToElement(driver, "//input[@name='uid']", userID);
		sendkeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		Assert.assertTrue(isElementDisplayed(driver, "//marquee[@class='heading3' and text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
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
