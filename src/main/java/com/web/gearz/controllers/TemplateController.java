package com.web.gearz.controllers;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.MongoException;
//import com.web.gearz.client.model.JSONView;
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
	public ModelAndView getTemplate(@RequestParam("userId") int userId,@RequestParam("templateId") short templateId){
		ModelAndView mav = new ModelAndView("sample");
		
		return mav;
	}
	
	public ModelAndView postContent(@RequestParam("domainId") int domainId,@RequestParam("divId") String divId,
			@RequestParam("content") String divContent){
		ModelAndView mav = new ModelAndView();
		//mav.setView(new JSONView());
		boolean response = false;
		try {
			filingService.storeContent(domainId, divId, divContent);
			response = true;
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.getModel().put("success",response);
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
