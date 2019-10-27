package com.Q.customer.details.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Q.customer.details.model.CreateCustomerProfileResponse;
import com.Q.customer.details.model.CustomerInformation;
import com.Q.customer.details.model.CustomerProfileRequest;
import com.Q.customer.details.model.DeleteCustomerProfile;
import com.Q.customer.details.model.UpdateCustomerProfileResponse;
import com.Q.customer.details.service.ICustomerProfileService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/Q/customerDetails", produces = "application/json")
@Api(description = "Set of REST Endpoint for Creating, Retrieving, Updating and Deleting Customer Profiles.")
public class CustomerController {
	
	@Autowired
	ICustomerProfileService customerProfileService;

	@RequestMapping(value="/retrieveCustomerprofile/{profileId}/{accountNumber}", method=RequestMethod.GET)
	@ApiOperation("Returns Customer Information based on customer ProfileId and Customer's Unique Account Number")
	public ResponseEntity<CustomerInformation> retrieveCustomerprofile(@PathVariable String profileId,@PathVariable String accountNumber) throws JsonParseException, JsonMappingException, IOException {
		
		return ResponseEntity.<CustomerInformation>ok().body(customerProfileService.retrieveCustomerprofile(profileId,accountNumber));
	}
	
	@RequestMapping(value="/createCustomerProfile", method=RequestMethod.POST )
	@ApiOperation("Create Customer new Profile  using  Customer's Unique Account Number and Request JSON.")
	public ResponseEntity<CreateCustomerProfileResponse> createCustomerProfile(@RequestHeader(name = "accountNumber")String customerAccountNumber,@RequestBody CustomerProfileRequest customerProfileRequst) throws JsonParseException, JsonMappingException, IOException {
		return ResponseEntity.<CreateCustomerProfileResponse>ok().body(customerProfileService.createCustomerProfile(customerAccountNumber,customerProfileRequst));
	}
	
	@RequestMapping(value="/updateCustomerProfile", method=RequestMethod.PUT )
	@ApiOperation("Update Existing Customer Profile Details.")
	public ResponseEntity<UpdateCustomerProfileResponse> updateCustomerProfile(@RequestHeader(name = "customerAccountNumber")String customerAccountNumber,@RequestHeader(name = "profileId") String profileId,@RequestBody CustomerProfileRequest customerProfileRequst) throws JsonParseException, JsonMappingException, IOException {
		return ResponseEntity.<UpdateCustomerProfileResponse>ok().body(customerProfileService.updateCustomerProfile(profileId,customerAccountNumber,customerProfileRequst));
	}
	
	@RequestMapping(value="/deleteCustomerProfile/{profileId}/{accountNumber}", method=RequestMethod.DELETE )
	@ApiOperation("Delete a Customer Profile.")
	public ResponseEntity<DeleteCustomerProfile> deleteCustomerProfile(@PathVariable String profileId,@PathVariable String accountNumber) throws JsonParseException, JsonMappingException, IOException {
		return ResponseEntity.<DeleteCustomerProfile>ok().body(customerProfileService.deleteCustomerProfile(profileId,accountNumber));
	}
	
}
