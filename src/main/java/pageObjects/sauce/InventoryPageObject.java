package pageObjects.sauce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.sauce.InventoryPageUI;

public class InventoryPageObject extends BasePage {
	WebDriver driver;

	public InventoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInDropdown(String itemText) {
		waitForElementClickable(driver, InventoryPageUI.DROPDOWN_LIST);
		selectItemInDropdownByText(driver, InventoryPageUI.DROPDOWN_LIST, itemText);

	}

	public boolean isProductNameSortByAscending() {

		List<WebElement> productNameElements = getElements(driver, InventoryPageUI.PRODUCT_NAME);

		List<String> productTexts = new ArrayList<String>();

		for (WebElement productNameElement : productNameElements) {
			productTexts.add(productNameElement.getText());

		}

		List<String> productTextsClone = new ArrayList<String>();
		for (String text : productTexts) {
			productTextsClone.add(text);
			
		}
		Collections.sort(productTextsClone);

		return productTexts.equals(productTextsClone);
	}

	public boolean isProductNameSortByDescending() {
		List<WebElement> productNameElements = getElements(driver, InventoryPageUI.PRODUCT_NAME);

		List<String> productTexts = new ArrayList<String>();

		for (WebElement productNameElement : productNameElements) {
			productTexts.add(productNameElement.getText());

		}

		List<String> productTextsClone = new ArrayList<String>();
		for (String text : productTexts) {
			productTextsClone.add(text);
			
		}
		Collections.sort(productTextsClone);
		Collections.reverse(productTextsClone);

		return productTexts.equals(productTextsClone);
	}

	public boolean isProductPriceNameSortByAscending() {
		
		List<WebElement> productPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE);

		List<Float> productPrices = new ArrayList<Float>();

		for (WebElement productPriceElement : productPriceElements) {
			
			productPrices.add(Float.parseFloat(productPriceElement.getText().replace("$", "").trim()));

		}

		List<Float> productPricesClone = new ArrayList<Float>();
		for (Float price : productPrices) {
			productPricesClone.add(price);
			
		}
		Collections.sort(productPricesClone);

		return productPrices.equals(productPricesClone);
	}

	public boolean isProductPriceNameSortByDescending() {
		List<WebElement> productPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE);

		List<Float> productPrices = new ArrayList<Float>();

		for (WebElement productPriceElement : productPriceElements) {
			
			productPrices.add(Float.parseFloat(productPriceElement.getText().replace("$", "").trim()));

		}

		List<Float> productPricesClone = new ArrayList<Float>();
		for (Float price : productPrices) {
			productPricesClone.add(price);
			
		}
		Collections.sort(productPricesClone);
		Collections.reverse(productPricesClone);

		return productPrices.equals(productPricesClone);
	}

}
