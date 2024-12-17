package com.sample.customersproducts.common;

import java.util.logging.Logger;

public class Logging {

	private String clazzName = getClass().getSimpleName();
	private final Logger log = Logger.getLogger(clazzName);
	
	public void logInfo(String method, String parameter) {
	
		if (null != parameter) {
			log.info("--- " + method + " --- " + parameter);
		} else {
			log.info("--- " + method + " --- ");
		}
	}
}
