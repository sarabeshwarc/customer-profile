package com.Q.customer.details.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class StreetInfo {
	
	private Integer streetNo;
	private String streetName;
	private String streetType;
}
