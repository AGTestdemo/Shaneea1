package com.qa.Swaag.Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {
Properties pro;	
	public ConfigDataProvider (){
		File src = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Unable to load Congig File " +e.getMessage());
		}
		
   }

public String getBrowser(String browser){
	return pro.getProperty(browser);
}
public String getUrl(String appUrl){
	return pro.getProperty(appUrl);
}


}
