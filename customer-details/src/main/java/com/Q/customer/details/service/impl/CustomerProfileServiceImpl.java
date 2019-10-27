package com.Q.customer.details.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.Q.customer.details.client.IClientCRM;
import com.Q.customer.details.common.AppConstant;
import com.Q.customer.details.exception.BadRequestException;
import com.Q.customer.details.exception.PayLoadException;
import com.Q.customer.details.exception.RestUnRecoverableException;
import com.Q.customer.details.exception.SystemErrorException;
import com.Q.customer.details.model.CreateCustomerProfileResponse;
import com.Q.customer.details.model.CustomerInformation;
import com.Q.customer.details.model.CustomerProfileRequest;
import com.Q.customer.details.model.DeleteCustomerProfile;
import com.Q.customer.details.model.UpdateCustomerProfileResponse;
import com.Q.customer.details.service.ICustomerProfileService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomerProfileServiceImpl implements ICustomerProfileService {

	private final static Logger LOGGER = LoggerFactory.getLogger(CustomerProfileServiceImpl.class);

	@Autowired
	IClientCRM clientCrm;

	@Override
	public CustomerInformation retrieveCustomerprofile(String profileId, String customerAccountNumber) throws JsonParseException, JsonMappingException, IOException {
		
		CustomerInformation retrieveCustomerprofileResponse = new CustomerInformation();
		
		checkCustomerAccountNumber(customerAccountNumber, profileId);
		
		try {

			String retrieveCustomerprofileResponseStr = clientCrm.retrieveCustomerProfile(profileId,
					customerAccountNumber);
			LOGGER.info(retrieveCustomerprofileResponseStr);
			
			checkNullResponseFromCRM(retrieveCustomerprofileResponseStr);
			
			ObjectMapper objectMapper = new ObjectMapper();
			retrieveCustomerprofileResponse = objectMapper.readValue(retrieveCustomerprofileResponseStr,new TypeReference<CustomerInformation>() {});
			
		} catch(RestUnRecoverableException re) {
			throw new RestUnRecoverableException(re.getErrorCode(), re.getErrorMessage());
		}

		return retrieveCustomerprofileResponse;
	}

	@Override
	public CreateCustomerProfileResponse createCustomerProfile(String customerAccountNumber,
			CustomerProfileRequest customerProfileRequest) throws JsonParseException, JsonMappingException, IOException {
		
		CreateCustomerProfileResponse createCustomerProfileResponse = new CreateCustomerProfileResponse();
		
		checkCustomerAccountNumber(customerAccountNumber, null);
		
		try {
			String createCustomerProfileResponseStr = clientCrm.createCustomerProfile(customerAccountNumber,
					customerProfileRequest);
			LOGGER.info(createCustomerProfileResponseStr);

			checkNullResponseFromCRM(createCustomerProfileResponseStr);

			ObjectMapper objectMapper = new ObjectMapper();
			createCustomerProfileResponse = objectMapper.readValue(createCustomerProfileResponseStr,new TypeReference<CreateCustomerProfileResponse>() {});
			
		} catch(RestUnRecoverableException re) {
			throw new RestUnRecoverableException(re.getErrorCode(), re.getErrorMessage());
		} 
		

		return createCustomerProfileResponse;
	}

	@Override
	public DeleteCustomerProfile deleteCustomerProfile(String profileId, String customerAccountNumber) throws JsonParseException, JsonMappingException, IOException {
		DeleteCustomerProfile deleteCustomerProfileResponse = new DeleteCustomerProfile();
		
		checkCustomerAccountNumber(customerAccountNumber, profileId);
		
		try {
			String deleteCustomerProfileResponseStr = clientCrm.deleteCustomerProfile(profileId, customerAccountNumber);
			LOGGER.info(deleteCustomerProfileResponseStr);
			
			checkNullResponseFromCRM(deleteCustomerProfileResponseStr);
			
			ObjectMapper objectMapper = new ObjectMapper();
			deleteCustomerProfileResponse = objectMapper.readValue(deleteCustomerProfileResponseStr,new TypeReference<DeleteCustomerProfile>() {});

		} catch(RestUnRecoverableException re) {
			throw new RestUnRecoverableException(re.getErrorCode(), re.getErrorMessage());
		}

		return deleteCustomerProfileResponse;
	}

	@Override
	public UpdateCustomerProfileResponse updateCustomerProfile(String profileId, String customerAccountNumber,
			CustomerProfileRequest customerProfileRequest) throws JsonParseException, JsonMappingException, IOException {
		
		UpdateCustomerProfileResponse updateCustomerProfileResponse = new UpdateCustomerProfileResponse();
		
		checkCustomerAccountNumber(customerAccountNumber, profileId);
		
		try {
			String updateCustomerProfileResponseStr = clientCrm.updateCustomerProfile(profileId, customerAccountNumber,
					customerProfileRequest);
			LOGGER.info(updateCustomerProfileResponseStr);
		
			checkNullResponseFromCRM(updateCustomerProfileResponseStr);
			
			ObjectMapper objectMapper = new ObjectMapper();
			updateCustomerProfileResponse = objectMapper.readValue(updateCustomerProfileResponseStr,new TypeReference<UpdateCustomerProfileResponse>() {});
			
		}catch(RestUnRecoverableException re) {
				throw new RestUnRecoverableException(re.getErrorCode(), re.getErrorMessage());
		}

		return updateCustomerProfileResponse;
	}

	public void checkCustomerAccountNumber(String customerAccountNumber, String profileId) {
		if (null == customerAccountNumber && null == profileId) {
			throw new BadRequestException(HttpStatus.BAD_REQUEST.value(), AppConstant.ErrorMessages.ID_CANNOT_BE_NULL);
		}
	}

	public void checkNullResponseFromCRM(String responseStrFromCRM) {

		if (null == responseStrFromCRM) {
			LOGGER.error(" Response is null :: " + AppConstant.ErrorMessages.NO_CUSTOMER_FOUND);
			throw new PayLoadException(HttpStatus.NOT_FOUND.value(),
					AppConstant.ErrorMessages.NO_CUSTOMER_FOUND);
		}
	}
}
