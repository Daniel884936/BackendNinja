package com.udemy.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {

	private final String ISE_VIEW = "error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternalServelError() {
		return ISE_VIEW;
	}
}
