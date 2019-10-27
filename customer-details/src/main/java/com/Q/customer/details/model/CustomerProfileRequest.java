package com.Q.customer.details.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @ApiModel(description ="Class representing to create a new customer profile.")
public class CustomerProfileRequest {
	
	@ApiModelProperty(notes="First name of the person.",example="Sarabeshwar",required = true )
	private String firstName;
	
	@ApiModelProperty(notes="Last name of the person.",example="Chandrasekar",required = true )
	private String lastName;
	
	@ApiModelProperty(notes="Date of Birth of the person",example="25-12-1988",required = true )
	private String dataOfBirth;
	
	@ApiModelProperty(notes="Contain detailed information about the complete address of the customer along with address type.", example="",required = true)
	private CustomerAddress address;
	
	@ApiModelProperty(notes="Represents the Customer's Unique Account Number",example="QANT756123S",required = true )
	private String customerAccountNumber;

}
