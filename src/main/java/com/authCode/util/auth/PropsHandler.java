package com.authCode.util.auth;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropsHandler {
	

	private static Properties props = null;
	static {
		try {
			if(null == props){
				props = new Properties();
			}
			InputStream in = PropsHandler.class.getResourceAsStream("/util.properties");
			props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		String property = PropsHandler.getProperty("key");
		System.out.println(property);
	}
	public final static String getProperty(String key) {
		return props.getProperty(key);
	}

	public final static String getProperty(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}
	
}
