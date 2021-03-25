package com.mars.javacode.excercise.exceptions;

public class PersonNotFoundException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public PersonNotFoundException(String message) {
		this.message = message;
		
		
	}
	public String getMessage() {
		return message;
	}
	
	

}
