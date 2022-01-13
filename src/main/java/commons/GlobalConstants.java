package commons;

import java.io.File;

public class GlobalConstants {
	
	public static int shortTimeout = 5;
	public static int longTimeout = 15;
	

	public static String PROJECT_PATH = System.getProperty("user.dir");
	public static String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFile";
	public static String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "downloadloadFile";
	public static String EXCEL_PATH = PROJECT_PATH + File.separator + "testdata" + File.separator + "UserInfor.xlsx" ;
	
	
}
