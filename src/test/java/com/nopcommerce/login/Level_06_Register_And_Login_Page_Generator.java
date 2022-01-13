package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_06_Register_And_Login_Page_Generator extends BaseTest {
	WebDriver driver;
	String password,email;
	
	@Parameters({"browser","appUrl"})
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {
		
		driver = getBrowserDriver(browserName, appUrl);

		email = getRandomEmail();
		password = "123456";
		
	}
	@Test
	public void Login_01_Register() {
		homePage = PageGeneratorManager.getHomepage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderRadioButton();
		registerPage.enterToFirstNameTextbox("Hieu");
		registerPage.enterToLastNameTextbox("Duong");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccessMessageDisplyed());
		
		homePage =registerPage.clickToLogoutLink();
		
	}
	
	@Test
	public void Login_02_Login() {
		loginPage =  homePage.clickToLoginLink();
				
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(password);
		
		homePage = loginPage.clickToLoginButton();
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





