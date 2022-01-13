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

public class Level_08_Register_And_Login_Switch_Page_Dynamic_locator extends BaseTest {
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

		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void Login_02_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void Login_03_Switch_Page_Dynamic_1() {
		// HomePage -> Search Page
		searchPage = (SearchPageObject) homePage.getFooterPageByPageName(driver, "Search");
		// Search Page -> MyAccount Page
		myaccountPage = (MyAccountPageObject) searchPage.getFooterPageByPageName(driver, "My account");
		// MyAccount Page -> Order page
		orderPage = (OrderPageObject) myaccountPage.getFooterPageByPageName(driver, "Orders");
		// Order Page -> MyAccount page
		myaccountPage = (MyAccountPageObject) orderPage.getFooterPageByPageName(driver, "My account");
		// MyAccount Page -> Order page
		orderPage = (OrderPageObject) myaccountPage.getFooterPageByPageName(driver, "Orders");
		// Order page -> Search page
		searchPage = (SearchPageObject) orderPage.getFooterPageByPageName(driver, "Search");
	}

	@Test
	public void Login_04_Switch_Page_Dynamic_2() {
		
		// search -> my account
		searchPage.openFooterPageByPageName(driver, "My account");
		myaccountPage= PageGeneratorManager.getMyAccountPage(driver);
		
		// myaccount -> order
		myaccountPage.openFooterPageByPageName(driver, "Orders");
		orderPage= PageGeneratorManager.getOrderPage(driver);
		
		// order -> search
		orderPage.openFooterPageByPageName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
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
