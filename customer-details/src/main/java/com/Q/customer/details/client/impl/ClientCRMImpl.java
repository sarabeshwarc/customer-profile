package com.Q.customer.details.client.impl;



import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.Q.customer.details.client.IClientCRM;
import com.Q.customer.details.common.Utility;
import com.Q.customer.details.exception.RestUnRecoverableException;
import com.Q.customer.details.model.CustomerProfileRequest;

@Component
public class ClientCRMImpl implements IClientCRM {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ClientCRMImpl.class);
	
	@Value("${host.url}")
	private String crmUrl;
	
	@Value("${create.profile}")
	private String createProfileEndPoint;
	
	@Value("${update.profile}")
	private String updateProfile;
	
	@Value("${delete.profile}")
	private String deleteProfile;
	
	@Value("${retrieve.profile}")
	private String retrieveProfile;
	
	@Autowired
	RestTemplate restTemplate;
	
	

	@Override
	public String createCustomerProfile(String customerAccountNumber, CustomerProfileRequest customerProfileRequest) throws JSONException  {
		ResponseEntity<String> profileDataString = null;
		String url = crmUrl + createProfileEndPoint;
		JSONObject input = new JSONObject();
		input.put("customerAccountNumber", customerAccountNumber);
		input.put("createProfileInput", customerProfileRequest);
		HttpEntity<String> entity = getEntity(input);
		try {
//			profileDataString = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		}catch(HttpClientErrorException e) {
			LOGGER.info("Exception in Creating Profile with message: " + e.getMessage() + " and status code : "
					+ e.getStatusCode().value());
			throw new RestUnRecoverableException(e.getStatusCode().value(), e.getMessage());
		}
		return Utility.returnJsonStub("createCustomerProfileResponse.json");
	}
	
	@Override
	public String updateCustomerProfile(String profileId, String customerAccountNumber,
			CustomerProfileRequest customerProfileRequest) {
		ResponseEntity<String> profileDataString = null;
		String url = crmUrl + updateProfile;
		JSONObject input = new JSONObject();
		input.put("customerAccountNumber", customerAccountNumber);
		input.put("customerProfileId", profileId);
		input.put("CustomerProfileRequest", customerProfileRequest);
		HttpEntity<String> entity = getEntity(input);
		try {
//			profileDataString = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
		}catch(HttpClientErrorException e) {
			LOGGER.info("Exception in Creating Profile with message: " + e.getMessage() + " and status code : "
					+ e.getStatusCode().value());
			throw new RestUnRecoverableException(e.getStatusCode().value(), e.getMessage());
		}
		return Utility.returnJsonStub("updateCustomerProfileResponse.json").toString();
	}
	
	@Override
	public String retrieveCustomerProfile(String profileId, String customerAccountNumber) {
		ResponseEntity<String> profileDataString = null;
		String url = crmUrl + retrieveProfile;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("customerProfileId", profileId).queryParam("customerAccountNumber", customerAccountNumber);
		LOGGER.info(builder.toString());
		HttpEntity<String> entity = getEntity(null);
		try {
//			profileDataString = restTemplate.exchange(builder.toString(), HttpMethod.GET, entity, String.class);
		}catch(HttpClientErrorException e) {
			LOGGER.info("Exception in Creating Profile with message: " + e.getMessage() + " and status code : "
					+ e.getStatusCode().value());
			throw new RestUnRecoverableException(e.getStatusCode().value(), e.getMessage());
		}
		LOGGER.info(Utility.returnJsonStub("retrieveCustomerProfileResponse.json").toString());
		return Utility.returnJsonStub("retrieveCustomerProfileResponse.json").toString();
	}

	
	@Override
	public String deleteCustomerProfile(String profileId, String customerAccountNumber) {
		ResponseEntity<String> profileDataString = null;
		String url = crmUrl + deleteProfile;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("customerProfileId", profileId).queryParam("customerAccountNumber", customerAccountNumber);
		
		HttpEntity<String> entity = getEntity(null);
		try {
//			profileDataString = restTemplate.exchange(builder.toString(), HttpMethod.DELETE, entity, String.class);
		}catch(HttpClientErrorException e) {
			LOGGER.info("Exception in Creating Profile with message: " + e.getMessage() + " and status code : "
					+ e.getStatusCode().value());
			throw new RestUnRecoverableException(e.getStatusCode().value(), e.getMessage());
		}
		return Utility.returnJsonStub("deleteCustomerProfileResponse.json").toString();
	}
	
	private HttpEntity<String> getEntity(JSONObject requestData) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
		String credentials = ("username" + ":" + "password");
		headers.set(HttpHeaders.AUTHORIZATION,
				"Basic " + new String(Base64.encodeBase64(credentials.getBytes())));
		HttpEntity<String> entity;
		if (null != requestData) {
			entity = new HttpEntity<String>(requestData.toString(), headers);
		} else {
			entity = new HttpEntity<String>("", headers);
		}
		return entity;
	}
	
	

	

	

}
