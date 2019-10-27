package com.qantas.customer.details;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.Q.customer.details.client.IClientCRM;
import com.Q.customer.details.common.AppConstant;
import com.Q.customer.details.common.Utility;
import com.Q.customer.details.exception.BadRequestException;
import com.Q.customer.details.exception.PayLoadException;
import com.Q.customer.details.model.CustomerInformation;
import com.Q.customer.details.service.ICustomerProfileService;
import com.Q.customer.details.service.impl.CustomerProfileServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class CustomerProfileServiceImplTest {
	
	@Injectable
	IClientCRM iClientCrm;
	
	@Tested
	CustomerProfileServiceImpl customerProfileServiceImpl;
	
	@Injectable
	ICustomerProfileService customerProfileService;
	
	@Test
	public void retrieveCustomerprofile() throws JsonParseException, JsonMappingException, IOException {
		final String mock = Utility.returnJsonStub("retrieveCustomerProfileResponse.json");
		
		
		new Expectations() {
            {
            	iClientCrm.retrieveCustomerProfile("profileId", "customerAccountNumber");
                result=(mock);
            }
        };       	        
        CustomerInformation actual = customerProfileServiceImpl.retrieveCustomerprofile("profileId", "customerAccountNumber");
        
        assertNotNull(actual);
	
	}
	
	@Test
	public void retrieveCustomerprofileException() throws JsonParseException, JsonMappingException, IOException {
		new Expectations() {
			{
				iClientCrm.retrieveCustomerProfile("profileId", "customerAccountNumber");
				result=(null);
			}
		};	
		
		try{
			customerProfileServiceImpl.retrieveCustomerprofile("profileId", "customerAccountNumber");
		}catch(PayLoadException pe) {
			assertEquals(AppConstant.ErrorMessages.NO_CUSTOMER_FOUND, pe.getErrorMessage());
		}
		
		try {
			customerProfileServiceImpl.retrieveCustomerprofile(null,null);
		}catch(BadRequestException be) {
			assertEquals(AppConstant.ErrorMessages.ID_CANNOT_BE_NULL, be.getErrorMessage());
		}
		
	}
	
	

}
