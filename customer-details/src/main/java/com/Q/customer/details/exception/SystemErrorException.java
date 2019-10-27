package com.Q.customer.details.exception;

public class SystemErrorException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2794536981121787760L;
	private Integer errorCode;
	private String errorMessage;

	public SystemErrorException(Integer errorCode, String errorMessage) {
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
