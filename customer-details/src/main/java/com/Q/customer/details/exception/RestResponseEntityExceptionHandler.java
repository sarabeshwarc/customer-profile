package com.Q.customer.details.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Q.customer.details.common.AppConstant;
import com.Q.customer.details.model.ErrorResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


@ControllerAdvice
@EnableWebMvc
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	ResponseEntity<Object> handleControllerException(HttpServletRequest req, Throwable ex) {
		ErrorResponse responseObject = new ErrorResponse();
		
		if(ex instanceof JsonParseException || ex instanceof JsonMappingException || ex instanceof IOException) {
			responseObject.setErrorMessage(AppConstant.ErrorMessages.JSON_PARSE_EXCEPTION);
			responseObject.setStatusCode(HttpStatus.FAILED_DEPENDENCY.value());
			return new ResponseEntity<Object>(responseObject,HttpStatus.UNAUTHORIZED);
		}
		return null;
	}
		 
	 @ExceptionHandler({RestUnRecoverableException.class})
	 @ResponseBody
	 public ResponseEntity<Object> handleRestUnRecoverableException(HttpServletRequest req, Throwable ex) {
		 ErrorResponse responseObject = new ErrorResponse();
		 responseObject.setErrorMessage(((RestUnRecoverableException) ex).getErrorMessage());
		 responseObject.setStatusCode(((RestUnRecoverableException) ex).getErrorCode());
		 return new ResponseEntity<Object>(responseObject,HttpStatus.valueOf(responseObject.getStatusCode()));
	 }
	 
	 @ExceptionHandler({BadRequestException.class})
	 @ResponseBody
	 public ResponseEntity<Object> handleBadRequestException(HttpServletRequest req, Throwable ex) {
		 ErrorResponse responseObject = new ErrorResponse();
		 responseObject.setErrorMessage(((BadRequestException) ex).getErrorMessage());
		 responseObject.setStatusCode(((BadRequestException) ex).getErrorCode());
		 return new ResponseEntity<Object>(responseObject,HttpStatus.valueOf(responseObject.getStatusCode()));
	 }
	 
	 @ExceptionHandler({PayLoadException.class})
	 @ResponseBody
	 public ResponseEntity<Object> handlePayLoadException(HttpServletRequest req, Throwable ex) {
		 ErrorResponse responseObject = new ErrorResponse();
		 responseObject.setErrorMessage(((BadRequestException) ex).getErrorMessage());
		 responseObject.setStatusCode(((BadRequestException) ex).getErrorCode());
		 return new ResponseEntity<Object>(responseObject,HttpStatus.valueOf(responseObject.getStatusCode()));
	 }
}