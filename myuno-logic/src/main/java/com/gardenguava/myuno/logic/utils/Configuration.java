/**
 * 
 */
package com.gardenguava.myuno.logic.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Leela Venkata Vundavalli
 *
 */
public class Configuration {
		private static Properties props = new Properties();
		private static InputStream inStream = null;
		private static int INITIAL_CARDS_FOR_PLAYER = 7;
		
		static {			
			try {
				inStream = new FileInputStream(".\\src\\main\\resources\\configuration.properties");
				if(inStream != null) {
					props.load(inStream);					
				} else {
					throw new FileNotFoundException("File not found: configuration.properties");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static String getProperty(String key) {
			return props.getProperty(key);
		}
		
		public static int getInitialCardsForPlayer() {
			return INITIAL_CARDS_FOR_PLAYER;
		}
}
