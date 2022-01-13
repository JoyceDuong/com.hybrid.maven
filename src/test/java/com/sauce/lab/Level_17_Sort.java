package com.sauce.lab;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.sauce.InventoryPageObject;
import pageObjects.sauce.LoginPageObject;
import pageObjects.sauce.PageGeneratorManager;

public class Level_17_Sort extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	InventoryPageObject inventoryPage;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {

		log.info("Open '"+ browserName +"' Browser");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		inventoryPage = loginPage.loginToSystem("standard_user","secret_sauce");

	}
	
	@Test
	public void Sort_01_Name() throws InterruptedException {
		inventoryPage.selectItemInDropdown("Name (A to Z)");
		Thread.sleep(2000);
		verifyTrue(inventoryPage.isProductNameSortByAscending());
		
		
		inventoryPage.selectItemInDropdown("Name (Z to A)");
		Thread.sleep(2000);
		verifyTrue(inventoryPage.isProductNameSortByDescending());
	}

	@Test
	public void Sort_02_Price() throws InterruptedException {
		inventoryPage.selectItemInDropdown("Price (low to high)");
		Thread.sleep(2000);
		verifyTrue(inventoryPage.isProductPriceNameSortByAscending());
		
		
		inventoryPage.selectItemInDropdown("Price (high to low)");
		Thread.sleep(2000);
		//verifyTrue(inventoryPage.isProductPriceNameSortByDescending());
		verifyTrue(inventoryPage.isProductPriceNameSortByAscending());
		
		
		
	}

	@AfterClass
	public void cleanBrowser() {
		log.info("Post-condition : Close browser");
		cleanBrowserAndDriver();
	}
}
