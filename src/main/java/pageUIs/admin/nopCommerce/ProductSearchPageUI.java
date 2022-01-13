package pageUIs.admin.nopCommerce;

public class ProductSearchPageUI {

	public static String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static String SEARCH_BUTTON = "//button[@id='search-products']";
	public static String SUCCESS_MESSAGE = "//div[@class='alert alert-success alert-dismissable' and contains(string(),'The product has been updated successfully.')]";
	public static String EDIT_BUTTON_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td[@class=' button-column']/a/i";
	public static String IMAGE_INFOR_BY_ROW_PRODUCT_NAME = "//td[text()='Adobe Photoshop CS4']/preceding-sibling::td/img[contains(@src,'%s')]";
}
