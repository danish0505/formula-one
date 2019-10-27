package com.service.formulaone.formulaone.exception;

public class BusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BusinessException(){
		super();
	}
	
	public BusinessException(String message){
		super(message);
	}
	

}
