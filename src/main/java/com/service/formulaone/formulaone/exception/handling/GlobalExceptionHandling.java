package com.service.formulaone.formulaone.exception.handling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.service.formulaone.formulaone.response.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ResponseEntity<ExceptionResponse> handleException(final Exception exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		error.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		
		ResponseEntity<ExceptionResponse>  response = new ResponseEntity<ExceptionResponse>(error, HttpStatus.BAD_REQUEST);

		return response;
	}

}
