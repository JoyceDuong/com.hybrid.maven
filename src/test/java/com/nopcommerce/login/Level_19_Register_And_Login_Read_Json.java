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

import Utilities.JsonConfig;
import commons.BasePage;
import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.MyAccountPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;

public class Level_19_Register_And_Login_Read_Json extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {

		log.info("Open '"+ browserName +"' Browser");
		driver = getBrowserDriver(browserName, appUrl);
		accountData = JsonConfig.getAccountInfor();
		


	}

	@Test
	public void Login_01_Register() {
		log.info("Login_01 - Step 01 : Verify HomePage is displayed");
		homePage = PageGeneratorManager.getHomepage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Login_01 - Step 02 : Click to Resiger link");
		homePage.openHeaderPageByPageName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		log.info("Login_01 - Step 03 : click to Gender radio button");
		registerPage.clickToGenderRadioButton();
		
		log.info("Login_01 - Step 04 : Enter To First Name Textbox");
		//registerPage.enterToFirstNameTextbox("Hieu");
		registerPage.enterToTextboxByID(driver,"FirstName","Hieu");
		
		log.info("Login_01 - Step 05 : Enter To Last Name Textbox");
		//registerPage.enterToLastNameTextbox("Duong");
		registerPage.enterToTextboxByID(driver,"LastName","Duong");
		
		log.info("Login_01 - Step 06 : Enter To Email Textbox" + accountData.getEmail());
		//registerPage.enterToEmailTextbox(email);
		registerPage.enterToTextboxByID(driver,"Email",accountData.getEmail());
	
		log.info("Login_01 - Step 07 : Enter To Password Textbox" + accountData.getPassword());
		//registerPage.enterToPasswordTextbox(password);
		registerPage.enterToTextboxByID(driver,"Password",accountData.getPassword());
		
		log.info("Login_01 - Step 08 : Enter To Confirm Password Textbox");
		//registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.enterToTextboxByID(driver,"ConfirmPassword",accountData.getPassword());
		

		log.info("Login_01 - Step 09 : Click To Register Button");
		registerPage.clickToRegisterButton();

		log.info("Login_01 - Step 10 : Verify HomePage is displayed");
		verifyTrue(registerPage.isSuccessMessageDisplyed());
		registerPage.openHeaderPageByPageName(driver, "Log out");
		homePage = PageGeneratorManager.getHomepage(driver);
	}

	@Test
	public void Login_02_Login() {
		log.info("Login_02 - Step 01 : Click To Login Button");
		homePage.openHeaderPageByPageName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Login_02 - Step 02 : Enter To Email Textbox");
		loginPage.enterToTextboxByID(driver,"Email",accountData.getEmail());
		
		log.info("Login_02 - Step 03 : Enter To Password Textbox");
		loginPage.enterToTextboxByID(driver,"Password",accountData.getPassword());

		log.info("Login_02 - Step 04 : Click To Login Button");
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isHomePageSliderDisplayed());
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
	JsonConfig accountData ;


	

	@AfterClass
	public void cleanBrowser() {
		log.info("Post-condition : Close browser");
		driver.quit();
	}
}
