package com.ally.base;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import com.ally.actions.TestEngine;
import com.ally.support.WebDriverFactory;
import com.ally.support.Xls_Reader;
import com.ally.util.Util;

public class DriverScript {

	public static final String TEST_DATA_PATH = System.getProperty("user.dir") + "/src/main/java/com/ally/data";
	public static Xls_Reader xls = new Xls_Reader (TEST_DATA_PATH + "/testdata.xlsx");
	public static WebDriver driver = null;
	public static String baseUrl = null;
	public static String BROWSER = null;
	public static int rowNum = 2;
	public static final URL scriptUrl = DriverScript.class.getResource("/axe.min.js");
	
	public static boolean isRunnable (String URL, String tcId, int row) throws NumberFormatException, IOException {
		rowNum = row;
		String runmode = xls.getCellData("TestData","Runmode",rowNum);
		try {
			if (runmode.toUpperCase().equals("YES")) {
				BROWSER = Util.getProperty ("Browser");
				driver = null;
				if (driver == null) {
					baseUrl = URL;
					String platform = Util.getProperty("Platform");
					if (platform.toUpperCase().equals("LOCAL")) {
						WebDriverFactory.initialize();
					}
					return true;
				}
			} else {
				System.out.println("Please check the runmode of your test case");
				return false;
			}
		} catch (Throwable t) {
			t.printStackTrace();
			return false;
		}
		return false;
	}
	
	@AfterMethod
	public void tearDown() {
		TestEngine.quit();
	}
	
}
