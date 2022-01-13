package com.jQuery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BasePage;
import commons.BaseTest;
import pageObjects.jQuery.DataTable.HomePageObject;
import pageObjects.jQuery.DataTable.PageGeneratorManager;

public class Level_09_Data_Table extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

	homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	public void Table_01_Paging() {
		
		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isPageDisplayed("5"));
		
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageDisplayed("15"));
		
		homePage.openPageByNumber("20");
		Assert.assertTrue(homePage.isPageDisplayed("20"));
		
	}

	
	public void Table_02_Input_To_Header() {
		
		homePage.inputToHeaderByName("minhhieu","Females");
		homePage.sleepInSecond(2);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderByName("minhhieu","Country");
		homePage.sleepInSecond(2);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderByName("minhhieu","Total");
		homePage.sleepInSecond(2);
		homePage.refreshCurrentPage(driver);
	}
	

	public void Table_03_Edit_Remove_Icon() {
		
		homePage.clickToIconByCountryName("Algeria","remove");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByCountryName("Aruba","edit");
		homePage.sleepInSecond(2);
	}
	
	
	public void Table_04_Verify_Row_Value() {
		homePage.inputToHeaderByName("Angola", "Country");
		Assert.assertTrue(homePage.isRowValueDisplayed("Angola","276880","276472","553353"));
	}

	@Test
	public void Table_05_Input_To_Row() {
		
		homePage.inputToTextboxByRowNumber("Contact Person","3","VietNam");
		homePage.sleepInSecond(3);
		
		homePage.inputToTextboxByRowNumber("Order Placed","2","Kohyoung");
		homePage.sleepInSecond(3);
		
		homePage.inputToTextboxByRowNumber("Contact Person","1","Hieu");
		homePage.sleepInSecond(3);
	}

	@Test
	public void Table_06_Click_Icon_By_Row_IconName() {
		
		homePage.clickToIconByRow("1","Move Down");
		
	}
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
}
