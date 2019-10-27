package com.Q.customer.details.common;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Q.customer.details.client.impl.ClientCRMImpl;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;



public class Utility {
	
private final static Logger LOGGER = LoggerFactory.getLogger(Utility.class);
	
	public static String returnJsonStub(String fileName) {

		String jsonStub = null;

		try {
			
			return Resources.toString(Resources.getResource(fileName), Charsets.UTF_8);

		} catch (Exception e) {
			LOGGER.error("FileNotFoundException in Profile service : ", e);
		}
		return jsonStub;
	}
	
	public static void main(String[] args) {
		System.out.println(returnJsonStub("retrieveCustomerProfileResponse.json"));
	}

}
