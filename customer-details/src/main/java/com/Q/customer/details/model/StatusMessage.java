package com.Q.customer.details.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @ApiModel(description ="Class representing Response Status Message")
public class StatusMessage {
	
	@ApiModelProperty(notes="Represents the status code from the CRM",example="200",required = true )
	private Integer statusCode;
	
	@ApiModelProperty(notes="Represents the statusDescription from the CRM",example="Successfully got the response from CRM",required = true )
	private String statusDescription;

}
