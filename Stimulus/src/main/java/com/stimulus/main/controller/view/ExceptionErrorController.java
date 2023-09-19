package com.stimulus.main.controller.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionErrorController {
	@ExceptionHandler(Exception.class)
	public String errorException(Exception exception, Model model) {
		model.addAttribute("exceptionData", exception.getMessage());
		//System.out.println(exception.getMessage());
		return "error1";
	}
}