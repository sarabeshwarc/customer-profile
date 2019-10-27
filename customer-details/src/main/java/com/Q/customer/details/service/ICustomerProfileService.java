package com.Q.customer.details.service;

import java.io.IOException;

import com.Q.customer.details.model.CreateCustomerProfileResponse;
import com.Q.customer.details.model.CustomerInformation;
import com.Q.customer.details.model.CustomerProfileRequest;
import com.Q.customer.details.model.DeleteCustomerProfile;
import com.Q.customer.details.model.UpdateCustomerProfileResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public interface ICustomerProfileService {
	
	public CustomerInformation retrieveCustomerprofile(String profileId,String customerAccountNumber) throws JsonParseException, JsonMappingException, IOException;
	
	public CreateCustomerProfileResponse createCustomerProfile(String customerAccountNumber,CustomerProfileRequest customerProfileRequest) throws JsonParseException, JsonMappingException, IOException;
	
	public DeleteCustomerProfile deleteCustomerProfile(String profileId, String customerAccountNumber) throws JsonParseException, JsonMappingException, IOException;
	
	public UpdateCustomerProfileResponse updateCustomerProfile(String profileId, String customerAccountNumber,CustomerProfileRequest customerProfileRequest) throws JsonParseException, JsonMappingException, IOException;

}
