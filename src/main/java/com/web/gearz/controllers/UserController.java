package com.web.gearz.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.gearz.models.Domain;

@Controller
public class UserController {
	
	@RequestMapping(value="/userDomains",method=RequestMethod.GET)
	public ModelAndView getUserDomains(@RequestParam("userId") int userId){
		ModelAndView mav = new ModelAndView("domainList");
		mav.getModel().put("domains", getDomains(userId));
		return mav;
	}

//	@RequestMapping(value="/getDomain",method=RequestMethod.GET)
//	public ModelAndView getDomain(@RequestParam("domainId") int domainId){
//		String getTemplate = 
//		ModelAndView mav = new ModelAndView()
//	}
	private List<Domain> getDomains(int userId) {
		// TODO Change to a real method
		List<Domain> userDomains = new ArrayList<Domain>();
		userDomains.add(mockDomain());
		return userDomains;
	}
	
	private Domain mockDomain(){
		Domain temp = new Domain();
		temp.setId(1);
		temp.setDomainName("www.temp.xyz.com");
		return temp;
	}

}
