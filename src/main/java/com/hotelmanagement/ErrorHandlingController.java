package com.hotelmanagement;


import java.text.ParseException;

import org.hibernate.HibernateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * 
 * @author M1024305
 * Global Exception Handler
 */
@ControllerAdvice
public class ErrorHandlingController {
	
	@ExceptionHandler
	public String handleHibernateException(HibernateException hex){
		return "error";
	}
	
	@ExceptionHandler
	public String handleParseException(ParseException pex){
		return "error";
	}
	
	@ExceptionHandler
	public String handleException(Exception ex){
		return "error";
	}

}
