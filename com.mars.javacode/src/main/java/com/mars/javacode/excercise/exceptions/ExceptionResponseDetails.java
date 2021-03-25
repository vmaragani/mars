package com.mars.javacode.excercise.exceptions;

import java.time.LocalDateTime;

public class ExceptionResponseDetails {
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private LocalDateTime date ;
	private String message;
	

}
