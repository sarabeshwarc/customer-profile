package com.Q.customer.details.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @ApiModel(description ="Class representing to Delete a customer profile.")
public class DeleteCustomerProfile {
	
	@ApiModelProperty(notes="Represents the Customer's Unique profileId",example="123",required = true )
	private String profileId;
	
	@ApiModelProperty(notes="Represents the Customer's Unique Account Number",example="QANT756123S",required = true )
	private String customerAccountNumber;
	
	@ApiModelProperty(notes="Represents the Customer's tenure with Qantas",example="5",required = true )
	private Integer tenure;
	
	@ApiModelProperty(notes="Represents the Customer's profile status like enrolled, eligible, active, inactive",example="QANT756123S",required = true )
	private String profileStatus;
	
	@ApiModelProperty(notes="Represents the Customer's profile create date",example="23-10-2019",required = true )
	private String createdDate;
	
	@ApiModelProperty(notes="Represents the Customer's profile inactive date",example="25-10-2023",required = true )
	private String inactiveDate;
	
	@ApiModelProperty(notes="Represents the status of the call",example="",required = true )
	private StatusMessage statusMessage;
}
