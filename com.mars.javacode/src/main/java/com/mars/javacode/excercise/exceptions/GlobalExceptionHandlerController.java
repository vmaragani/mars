package com.mars.javacode.excercise.exceptions;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value=PersonNotFoundException.class)
	@ResponseBody
	private ExceptionResponseDetails handleException() {
		ExceptionResponseDetails response = new ExceptionResponseDetails();
        response.setDate(LocalDateTime.now());
        response.setMessage("Person Not found---------");
		return response;
		
		
	}

}
