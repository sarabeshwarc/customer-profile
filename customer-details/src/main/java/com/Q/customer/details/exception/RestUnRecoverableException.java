package com.Q.customer.details.exception;

/**
 * Models exceptions that cannot be recovered from by re-submitting the REST request so there's no point in trying.
 * 
 * @author priyanka
 *
 */
public class RestUnRecoverableException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer errorCode;
	private String errorMessage;

	public RestUnRecoverableException(Integer errorCode, String errorMessage) {
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
