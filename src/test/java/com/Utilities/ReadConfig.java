package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig() {
		File src = new File("./Configurations/config.properties"); 
		pro = new Properties();
		
		try {
			FileInputStream fi = new FileInputStream(src);
			pro.load(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		String url = pro.getProperty("url");
		return url;
	}

	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getAppname() {
		String appname = pro.getProperty("app");
		return appname;
	}
	

}
