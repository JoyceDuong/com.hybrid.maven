package pageObjects.jQuery.DataTable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.DataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_NUMBER_BY_TEXT, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_NUMBER_BY_TEXT, pageNumber);
	}

	public boolean isPageDisplayed(String pageNumber) {
		waitForAllElementsVisible(driver, HomePageUI.HEADER_TEXT_BY_NAME, pageNumber);
		return isElementDisplayed(driver, HomePageUI.HEADER_TEXT_BY_NAME, pageNumber);

	}

	public void inputToHeaderByName(String value, String headerName) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXT_BY_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXT_BY_NAME, value, headerName);
		presskeyToElement(driver, HomePageUI.HEADER_TEXT_BY_NAME, Keys.ENTER, headerName);
	}

	public void clickToIconByCountryName(String countryName, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconName);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconName);
	}

	public boolean isRowValueDisplayed(String country, String females, String males, String total) {

		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_DATA, country, females, males, total);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_DATA, country, females, males, total);
	}

	public void inputToTextboxByRowNumber(String columnName, String rowNumber, String value) {

		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX, columnName) + 1;

		waitForElementVisible(driver,  HomePageUI.CELL_INDEX_BY_COLUMN_ROW, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.CELL_INDEX_BY_COLUMN_ROW, value, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRow(String rowNumber, String iconName) {
		
		waitForElementClickable(driver, HomePageUI.ICON_BY_NAME_ROW, rowNumber,iconName);
		clickToElement(driver, HomePageUI.ICON_BY_NAME_ROW, rowNumber,iconName);
		
	}

}
