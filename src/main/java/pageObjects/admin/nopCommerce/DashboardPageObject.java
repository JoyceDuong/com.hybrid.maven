package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.admin.nopCommerce.DashboardPageUI;
import pageUIs.admin.nopCommerce.LoginPageUI;

public class DashboardPageObject extends BasePage {
	private WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductSearchPageObject openProductSearchPage(String menuName , String subMenuName) {
		waitForElementClickable(driver, DashboardPageUI.MENU_LINK_BY_NAME,menuName);
		clickToElement(driver, DashboardPageUI.MENU_LINK_BY_NAME,menuName);
		waitForElementClickable(driver, DashboardPageUI.SUBMENU_LINK_BY_NAME,menuName,subMenuName);
		clickToElement(driver, DashboardPageUI.SUBMENU_LINK_BY_NAME,menuName,subMenuName);
		return PageGeneratorManager.getProductSearchPage(driver);
	}
	
	
}
