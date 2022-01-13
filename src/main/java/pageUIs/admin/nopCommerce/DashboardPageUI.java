package pageUIs.admin.nopCommerce;

public class DashboardPageUI {

	public static String MENU_LINK_BY_NAME = "//ul[@role='menu']/li/a/p[contains(text(),'%s')]";
	public static String SUBMENU_LINK_BY_NAME = "//p[contains(text(),'%s')]/parent::a/following-sibling::ul//p[text()=' %s']";

}

