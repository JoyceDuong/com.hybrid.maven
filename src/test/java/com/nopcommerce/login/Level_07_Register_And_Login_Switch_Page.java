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
import pageObjects.user.nopCommerce.MyAccountPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;

public class Level_07_Register_And_Login_Switch_Page extends BaseTest {
	WebDriver driver;
	String password, email;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {

		log.info("Open '"+ browserName +"' Browser");
		driver = getBrowserDriver(browserName, appUrl);

		email = getRandomEmail();
		password = "123456";

	}

	@Test
	public void Login_01_Register() {
		log.info("Login_01 - Step 01 : Verify HomePage is displayed");
		homePage = PageGeneratorManager.getHomepage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Login_01 - Step 02 : Click to Resiger link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Login_01 - Step 03 : click to Gender radio button");
		registerPage.clickToGenderRadioButton();
		
		log.info("Login_01 - Step 04 : Enter To First Name Textbox");
		registerPage.enterToFirstNameTextbox("Hieu");
		
		log.info("Login_01 - Step 05 : Enter To Last Name Textbox");
		registerPage.enterToLastNameTextbox("Duong");
		
		log.info("Login_01 - Step 06 : Enter To Email Textbox");
		registerPage.enterToEmailTextbox(email);
	
		log.info("Login_01 - Step 07 : Enter To Password Textbox");
		registerPage.enterToPasswordTextbox(password);
		
		log.info("Login_01 - Step 08 : Enter To Confirm Password Textbox");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Login_01 - Step 09 : Click To Register Button");
		registerPage.clickToRegisterButton();

		log.info("Login_01 - Step 10 : Verify HomePage is displayed");
		Assert.assertTrue(registerPage.isSuccessMessageDisplyed());
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void Login_02_Login() {
		log.info("Login_02 - Step 01 : Click To Login Button");
		loginPage = homePage.clickToLoginLink();

		log.info("Login_02 - Step 02 : Enter To Email Textbox");
		loginPage.enterToEmailTextbox(email);
		
		log.info("Login_02 - Step 03 : Enter To Password Textbox");
		loginPage.enterToPasswordTextbox(password);

		log.info("Login_02 - Step 04 : Click To Login Button");
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void Login_03_Switch_Page() {
		log.info("Login_03 - Step 01 : Switch to search Page from homepage ");
		searchPage = homePage.openSearchPage(driver);
		
		log.info("Login_03 - Step 02 : Switch to My account Page from searchpage ");
		myaccountPage = searchPage.openMyAccountPage(driver);
		
		log.info("Login_03 - Step 03 : Switch to search Page from orderpage ");
		orderPage = myaccountPage.openOrderPage(driver);
		// Order Page -> MyAccount page
		log.info("Login_03 - Step 04 : Switch to Open Page from My account page ");
		myaccountPage = orderPage.openMyAccountPage(driver);
		// MyAccount Page -> Order page
		
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myaccountPage;
	OrderPageObject orderPage;

	public String getRandomEmail() {
		Random rand = new Random();

		return "testing" + rand.nextInt(9999) + "@gmail.com";

	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
}
