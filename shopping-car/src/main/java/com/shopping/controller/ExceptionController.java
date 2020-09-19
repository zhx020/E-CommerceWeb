package com.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionController {
	@ExceptionHandler({RuntimeException.class})
	private String handleException(RuntimeException ex) {
		System.out.println(ex.getMessage());
		return "error";
	}
}
