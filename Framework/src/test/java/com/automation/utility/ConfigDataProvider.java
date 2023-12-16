/**
 * 
 */
package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 */
public class ConfigDataProvider {
	Properties pro;

	public ConfigDataProvider() throws FileNotFoundException 
	{
		File src = new File("./Configuration/Config.properties");
		FileInputStream fis = new FileInputStream(src);
		
		pro =  new Properties();
		try {
			pro.load(fis);
		} catch (IOException e) {
			System.out.println("Not able to load config file");
			e.printStackTrace();
		}
		
	}

	public String getDataFromConfig(String keyToSearch)
	{
		return pro.getProperty(keyToSearch);
	}
	public String getBroswer()
	{
		return pro.getProperty("Browser");
	}
	
	public String getStagingURL()
	{
		return pro.getProperty("qaURL");
	}
	
}
