package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static LoginPageObject loginPage;
	private static DashboardPageObject dashboardPage;
	private static ProductSearchPageObject productSearchPage;
	private static ProductDetailPageObject productDetailPage;
	
	private PageGeneratorManager() {
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage==null) {
			loginPage= new LoginPageObject(driver);
		}
		return new LoginPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		if (dashboardPage==null) {
			dashboardPage= new DashboardPageObject(driver);
		}
		return new DashboardPageObject(driver);
	}
	
	public static ProductSearchPageObject getProductSearchPage(WebDriver driver) {
		if (productSearchPage==null) {
			productSearchPage= new ProductSearchPageObject(driver);
		}
		return new ProductSearchPageObject(driver);
	}
	
	public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
		if (productDetailPage==null) {
			productDetailPage= new ProductDetailPageObject(driver);
		}
		return new ProductDetailPageObject(driver);
	}
}
