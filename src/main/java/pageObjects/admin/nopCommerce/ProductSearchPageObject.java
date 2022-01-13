package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.admin.nopCommerce.ProductSearchPageUI;

public class ProductSearchPageObject extends BasePage {
	private WebDriver driver;
	
	public ProductSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, ProductSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductSearchPageUI.SEARCH_BUTTON);
	}

	public void clickToEditButtonByProductName(String productName) {
		waitForElementClickable(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, ProductSearchPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, ProductSearchPageUI.SUCCESS_MESSAGE) ;
	}

	public boolean isPictureImageUpdated(String productName) {
		String lowerCaseProductName = productName.toLowerCase();
		String srcProductName = lowerCaseProductName.replace(" ", "-");
		waitForElementVisible(driver, ProductSearchPageUI.IMAGE_INFOR_BY_ROW_PRODUCT_NAME, srcProductName);
		return isElementDisplayed(driver, ProductSearchPageUI.IMAGE_INFOR_BY_ROW_PRODUCT_NAME, srcProductName);
		 
	}
	
	
}
