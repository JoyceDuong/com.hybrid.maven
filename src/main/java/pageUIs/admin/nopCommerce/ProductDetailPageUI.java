package pageUIs.admin.nopCommerce;

public class ProductDetailPageUI {
	public static String EXPAND_BUTTON_BY_PANEL_NAME = "//div[@id='product-%s']//button[@data-card-widget='collapse']/i";
	public static String ALT_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static String TITLE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static String DISPLAY_ORDER_TEXTBOX = "//input[@id='AddPictureModel_DisplayOrder']/preceding-sibling::input";
	public static String IMAGE_NAME = "//div[@class='picture-container']//img[contains(@src,'%s')]";
	public static String ADD_PRODUCT_BUTTON = "//button[@id='addProductPicture']";
	public static String SAVE_BUTTON = "//button[@name='save']";
	public static String IMAGE_INFOR_IN_TABLE = "//a[contains(@href,'%s')]/parent::td/following-sibling::td[@data-columnname='DisplayOrder' and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='%s']";
	public static String DELETE_BUTTON_BY_TITLE = "//td[@data-columnname='OverrideTitleAttribute' and text()='%s']//following-sibling::td/a[contains(string(),'Delete')]";
	public static String NO_DATA_MESSAGE = "//div[@data-card-name='product-pictures']//td[text()='No data available in table']";
	public static String INCREASE_ORDER_DISPLAY = "//div[@id='product-pictures']//span[@class='k-numeric-wrap k-state-default']//span[@class='k-icon k-i-arrow-60-up']";
}
