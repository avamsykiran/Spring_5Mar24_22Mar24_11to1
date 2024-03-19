package com.cts.webdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	// @RequestMapping(value = {"","/","/home","/index"},method=RequestMethod.GET)
	@GetMapping({ "", "/", "/home", "/index" })
	public String showHomePageAction() {
		return "home";
	}

	@GetMapping("/aboutUs")
	public ModelAndView showAboutUsPageAction(@RequestParam(name = "unm",required = false) String userName) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("aboutUs");

		mv.addObject("team", new String[]{  "Vamsy","Anitha","Anand","Siva"});
		
		if(userName!=null) {
			mv.addObject("msg","We are happy to consider your reqeust Mr./Ms."+userName);
		}
		
		return mv;
	}

	@RequestMapping("/header")
	public ModelAndView showHeaderAction() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("header");

		mv.addObject("appName", "Spring Boot Based Spring Web MVC Application 1.0");

		mv.addObject("links", new String[][] { { "Home", "/home" }, { "About Us", "/aboutUs" } });

		return mv;
	}

}
