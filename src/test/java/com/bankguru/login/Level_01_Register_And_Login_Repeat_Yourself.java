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

public class Level_01_Register_And_Login_Repeat_Yourself {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String userID,password,loginPageUrl,email;
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver",projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
		
		loginPageUrl = driver.getCurrentUrl();
	}

	@Test
	public void Login_01_Register() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.name("emailid")).sendKeys(getRandomEmail());
		driver.findElement(By.name("btnLogin")).click();
		
	 userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	 password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}
	
	@Test
	public void Login_02_Login() {
		
		driver.get(loginPageUrl);
		
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();
		
		Assert.assertTrue(driver
				.findElement(By
						.xpath("//marquee[@class='heading3' and text()=\"Welcome To Manager's Page of Guru99 Bank\"]"))
				.isDisplayed());
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
