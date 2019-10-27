package com.Q.customer.details.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString  
public class CustomerInformation {
	
	@JsonProperty("customerAccountNumber")
	private String customerAccountNumber;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("dateOfBirth")
	private String dateOfBirth;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("addressType")
	private String addressType;
	
	@JsonProperty("profileId")
	private String profileId;
	
	
}
