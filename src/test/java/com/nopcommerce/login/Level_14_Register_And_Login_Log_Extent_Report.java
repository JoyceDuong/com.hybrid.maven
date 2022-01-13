package com.nopcommerce.login;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.MyAccountPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;
import reportConfig.ExtentTestManager;

public class Level_14_Register_And_Login_Log_Extent_Report extends BaseTest {
	WebDriver driver;
	String password, email;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);

		email = getRandomEmail();
		password = "123456";

	}

	@Test
	public void Login_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_NewCustomer");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01 - Step 01 : Verify HomePage is displayed");
		homePage = PageGeneratorManager.getHomepage(driver);
		verifyFalse(homePage.isHomePageSliderDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01 - Step 02 : Click to Resiger link");
		registerPage = homePage.clickToRegisterLink();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01 - Step 03 : click to Gender radio button");
		registerPage.clickToGenderRadioButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01 - Step 04 : Enter To First Name Textbox");
		registerPage.enterToFirstNameTextbox("Hieu");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01 - Step 05 : Enter To Last Name Textbox");
		registerPage.enterToLastNameTextbox("Duong");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01 - Step 06 : Enter To Email Textbox" + email);
		registerPage.enterToEmailTextbox(email);
	
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01 - Step 07 : Enter To Password Textbox" + password);
		registerPage.enterToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01 - Step 08 : Enter To Confirm Password Textbox");
		registerPage.enterToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01 - Step 09 : Click To Register Button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01 - Step 10 : Verify HomePage is displayed");
		verifyTrue(registerPage.isSuccessMessageDisplyed());
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void Login_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Login");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01 - Step 01 : Verify HomePage is displayed");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02 - Step 01 : Click To Login Button");
		loginPage = homePage.clickToLoginLink();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02 - Step 02 : Enter To Email Textbox");
		loginPage.enterToEmailTextbox(email);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02 - Step 03 : Enter To Password Textbox");
		loginPage.enterToPasswordTextbox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02 - Step 04 : Click To Login Button");
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isHomePageSliderDisplayed());
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
		log.info("Post-condition : Close browser");
		driver.quit();
	}
}
