package com.Q.customer.details.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class CustomerAddress {

	private Integer unitNo;
	private String addressType;
	private StreetInfo street;
	private String suburb;
	private Integer postcode;
	private String state;
}
