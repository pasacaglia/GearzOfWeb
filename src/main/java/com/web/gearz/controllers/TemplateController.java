package com.web.gearz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.gearz.models.User;
import com.web.gearz.services.FilingService;

@Controller
public class TemplateController {
	
	private FilingService filingService;
	@RequestMapping(value="/getAllTemplates",method=RequestMethod.GET)
	public ModelAndView getTemplatesOfUser(){
		ModelAndView mav = new ModelAndView("templateList");
		
		return mav;
	}
	
	@RequestMapping(value="/getTemplate",method=RequestMethod.GET)
	public ModelAndView getTemplate(){
		ModelAndView mav = new ModelAndView("sample");
		return mav;
	}

	@Autowired
	public void setFilingService(FilingService filingService) {
		this.filingService = filingService;
	}

	public FilingService getFilingService() {
		return filingService;
	}

}
