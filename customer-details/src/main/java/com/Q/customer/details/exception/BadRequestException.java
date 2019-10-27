package com.Q.customer.details.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Integer errorCode;
	private String errorMessage;

	public BadRequestException(Integer errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}


}

