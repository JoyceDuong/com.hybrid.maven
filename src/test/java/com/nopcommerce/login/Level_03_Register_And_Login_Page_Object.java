package com.nopcommerce.login;

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
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_03_Register_And_Login_Page_Object {
	WebDriver driver;
	
	String projectPath = System.getProperty("user.dir");
	String userID,password,loginPageUrl,email;
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver",projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS );
		driver.manage().window().maximize();
		email = getRandomEmail();
		password = "123456";
		
	}
	@Test
	public void Login_01_Register() {
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.clickToGenderRadioButton();
		registerPage.enterToFirstNameTextbox("Hieu");
		registerPage.enterToLastNameTextbox("Duong");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccessMessageDisplyed());
		
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
		
		
	}
	
	@Test
	public void Login_02_Login() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
				
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	public String getRandomEmail() {
		Random rand = new Random();
		
		return "testing" + rand.nextInt(9999) + "@gmail.com";
		
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
}





