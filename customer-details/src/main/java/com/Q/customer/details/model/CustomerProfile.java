package com.Q.customer.details.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class CustomerProfile {

	private Integer profileId;
	private String status;
	private String accountNumber;
	private Integer tenure;
	private String createdDate;
	private String changeDate;
	
	
}
