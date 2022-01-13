package pageUIs.jQuery.DataTable;

public class HomePageUI {

	public static final String PAGE_NUMBER_BY_TEXT = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_NUMBER_ACTIVED_BY_TEXT = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXT_BY_NAME = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String ICON_BY_COUNTRY_NAME = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	public static final String ROW_VALUE_BY_DATA = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String COLUMN_INDEX = "//th[text()='%s']/preceding-sibling::th";
	public static final String CELL_INDEX_BY_COLUMN_ROW = "//tr[%s]/td[%s]/input";
	public static final String ICON_BY_NAME_ROW = "//tr[@data-unique-index='%s']//button[@title='%s']";
}
