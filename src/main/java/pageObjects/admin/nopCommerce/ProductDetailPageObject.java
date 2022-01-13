package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.admin.nopCommerce.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage {
	private WebDriver driver;
	String avatarName = "edit11.jpg";
	String avataPath = System.getProperty("user.dir") + "\\uploadFile\\" + avatarName;

	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpandPanelByName(String panelName) {
		panelName = panelName.toLowerCase();
		scrollToElement(driver, ProductDetailPageUI.EXPAND_BUTTON_BY_PANEL_NAME, panelName);
		waitForElementClickable(driver, ProductDetailPageUI.EXPAND_BUTTON_BY_PANEL_NAME, panelName);
		String statusIcon = getElementAttribute(driver, ProductDetailPageUI.EXPAND_BUTTON_BY_PANEL_NAME, "class",
				panelName);
		if (statusIcon.contains("fa-plus")) {
			clickToElement(driver, ProductDetailPageUI.EXPAND_BUTTON_BY_PANEL_NAME, panelName);
		}
	}

	public void enterToAltTextbox(String value) {
		waitForElementVisible(driver, ProductDetailPageUI.ALT_TEXTBOX);
		sendkeyToElement(driver, ProductDetailPageUI.ALT_TEXTBOX, value);

	}

	public boolean isPictureUploadedByFileName() {
		String newAvataName = avatarName.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailPageUI.IMAGE_NAME, newAvataName);
		return isElementDisplayed(driver, ProductDetailPageUI.IMAGE_NAME, newAvataName);
	}

	public void enterToTitleTextbox(String value) {
		waitForElementVisible(driver, ProductDetailPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, ProductDetailPageUI.TITLE_TEXTBOX, value);

	}

	public void enterToDisplayOrderTextbox(String value) {
		waitForElementVisible(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX);
		String title = getElementAttribute(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX, "title");
		
		while (!title.equals("1")) {
			clickToElement(driver, ProductDetailPageUI.INCREASE_ORDER_DISPLAY);
			break;
		}
//		if (!title.equals("1")) {
//			clickToElement(driver, ProductDetailPageUI.INCREASE_ORDER_DISPLAY);
//		}
		//sendkeyToElement(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX, value);

	}

	public void clickToAddProductPicture() {
		waitForElementClickable(driver, ProductDetailPageUI.ADD_PRODUCT_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_PRODUCT_BUTTON);
	}

	public boolean isPictureDisplaySuccess(String productName, String orderNumber, String altName, String tiltleName) {
		productName = productName.toLowerCase().replace(" ", "-");
		waitForElementVisible(driver, ProductDetailPageUI.IMAGE_INFOR_IN_TABLE, productName, orderNumber, altName,
				tiltleName);
		return isElementDisplayed(driver, ProductDetailPageUI.IMAGE_INFOR_IN_TABLE, productName, orderNumber, altName,
				tiltleName);
	}

	public ProductSearchPageObject clickToSaveButton() {
		waitForElementClickable(driver, ProductDetailPageUI.SAVE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductSearchPage(driver);
	}

	public void clickToDeleteButtonByTiltle(String tiltleName) {
		waitForElementClickable(driver, ProductDetailPageUI.DELETE_BUTTON_BY_TITLE, tiltleName);
		clickToElement(driver, ProductDetailPageUI.DELETE_BUTTON_BY_TITLE, tiltleName);
		acceptAlert(driver);
	}

	public boolean isMessageDisplayedInTable() {
		waitForElementVisible(driver, ProductDetailPageUI.NO_DATA_MESSAGE);
		return isElementDisplayed(driver, ProductDetailPageUI.NO_DATA_MESSAGE);
	}

}
