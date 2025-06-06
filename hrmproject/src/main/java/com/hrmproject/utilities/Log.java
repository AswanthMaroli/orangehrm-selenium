
package com.hrmproject.utilities;

import org.apache.log4j.Logger;

/**
 *
 * @author Aswanth Maroli
 * @date   Jun 5, 2025
 */

public class Log {
	
	public static Logger log = Logger.getLogger(Log.class.getName());
	
	
	public static void startTestCase(String testCase) {
		
		log.info("==================================="+testCase+" Test Start ===================================");
	}
	
	public static void endTestCase(String testCase) {
			
		log.info("==================================="+testCase+" Test End ===================================");
	}
	
	public static void info(String message) {
		
		log.info(message);
	}
	
	public static void warn(String message) {
		
		log.warn(message);
	}
	
	public static void error(String message) {
		
		log.error(message);
	}

}
