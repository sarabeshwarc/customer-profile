package com.Q.customer.details.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @ApiModel(description ="Class representing create Customer Profile Response")
public class CreateCustomerProfileResponse {

	@ApiModelProperty(notes="Status of the Create Request.",example="Success",required = true )
	private String status;
	@ApiModelProperty(notes="Persisted Customer Details",example="",required = true )
	private CustomerProfile customerProfile;
	
}
