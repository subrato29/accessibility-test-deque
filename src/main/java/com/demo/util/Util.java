package com.demo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Util {
	
	public static String getProperty (String value) throws IOException {
		try {
			String path = System.getProperty("user.dir") + "/config.properties";
			Properties prop = new Properties();
			FileInputStream fs = new FileInputStream(path);
			prop.load (fs);
			value = prop.getProperty(value).trim();
			return value;
		} catch(Throwable t) {
			return null;
		}
	}
}
