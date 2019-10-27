package com.Q.customer.details.client;

import org.json.JSONException;

import com.Q.customer.details.model.CustomerProfileRequest;

public interface IClientCRM {
	
	public String createCustomerProfile(String customerAccountNumber,CustomerProfileRequest customerProfileRequest) throws JSONException;
	
	public String updateCustomerProfile(String profileId, String customerAccountNumber,CustomerProfileRequest customerProfileRequest);
	
	public String retrieveCustomerProfile(String profileId,String customerAccountNumber);
	
	public String deleteCustomerProfile(String profileId, String customerAccountNumber);
	
}
