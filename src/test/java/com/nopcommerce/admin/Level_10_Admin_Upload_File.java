package com.nopcommerce.admin;

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
import pageObjects.admin.nopCommerce.DashboardPageObject;
import pageObjects.admin.nopCommerce.LoginPageObject;
import pageObjects.admin.nopCommerce.PageGeneratorManager;
import pageObjects.admin.nopCommerce.ProductDetailPageObject;
import pageObjects.admin.nopCommerce.ProductSearchPageObject;

public class Level_10_Admin_Upload_File extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	ProductSearchPageObject productSearchPage;
	ProductDetailPageObject productDetaiPage;
	String avataName = "edit11.jpg";
	String productName = "Adobe Photoshop CS4";
	String orderNumber = "1";
	String altName = "minhhieu";
	String tiltleName = "duong";

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToEmailTextbox("admin@yourstore.com");
		loginPage.enterToPasswordTextbox("admin");
		loginPage.clickToLoginButton();
		dashboardPage = PageGeneratorManager.getDashboardPage(driver);

		productSearchPage = dashboardPage.openProductSearchPage("Catalog","Products");
		productSearchPage.enterToProductNameTextbox(productName);
		productSearchPage.clickToSearchButton();
		productSearchPage.clickToEditButtonByProductName(productName);
		productDetaiPage = PageGeneratorManager.getProductDetailPage(driver);

	}

	@Test
	public void Login_01_Upload_File() {

		productDetaiPage.clickToExpandPanelByName("pictures");
		
		productDetaiPage.uploadMultipleFiles(driver,avataName);
		
		verifyTrue(productDetaiPage.isPictureUploadedByFileName());

		productDetaiPage.enterToAltTextbox(altName);
		
		productDetaiPage.enterToTitleTextbox(tiltleName);
		
		productDetaiPage.enterToDisplayOrderTextbox(orderNumber);
		
		productDetaiPage.clickToAddProductPicture();
		
		verifyTrue(productDetaiPage.isPictureDisplaySuccess(productName, orderNumber,altName , tiltleName));

		productSearchPage = productDetaiPage.clickToSaveButton();
		
		verifyTrue(productSearchPage.isSuccessMessageDisplayed());

		productSearchPage.enterToProductNameTextbox("Adobe Photoshop CS4");
		
		productSearchPage.clickToSearchButton();
		
		verifyTrue(productSearchPage.isPictureImageUpdated("Adobe Photoshop CS4"));

		productSearchPage.clickToEditButtonByProductName("Adobe Photoshop CS4");
		productDetaiPage = PageGeneratorManager.getProductDetailPage(driver);
		
		productDetaiPage.clickToExpandPanelByName("Pictures");
		
		productDetaiPage.clickToDeleteButtonByTiltle(tiltleName); // alert
		verifyTrue(productDetaiPage.isMessageDisplayedInTable());
		

	}

	@AfterClass
	public void cleanBrowser() {
		cleanBrowserAndDriver();
	}
}
