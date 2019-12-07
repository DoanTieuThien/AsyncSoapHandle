package com.its.webservice.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

@Controller
public class ErrorControllerImpl implements ErrorController {

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "";
	}

}
