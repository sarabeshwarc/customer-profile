package com.Q.customer.details.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class UpdateCustomerProfileResponse {
	private StatusMessage statusMessage;
	private String profileId;
	private String customerAccountNumber;
}
