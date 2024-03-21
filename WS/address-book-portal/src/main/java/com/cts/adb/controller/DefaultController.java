package com.cts.adb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	@GetMapping({ "", "/", "/home", "/index" })
	public String showHomePageAction() {
		return "home";
	}

	@RequestMapping("/header")
	public ModelAndView showHeaderAction() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("header");

		mv.addObject("appName", "AddressBook 2.0");

		mv.addObject("links",
				new String[][] { 
					{ "Home", "/home" } ,
					{ "Contacts", "/contacts/list" },
					{ "New Contact", "/contacts/add" } 
				});

		return mv;
	}

}
