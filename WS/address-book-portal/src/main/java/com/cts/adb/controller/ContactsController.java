package com.cts.adb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.adb.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/list")
	public ModelAndView showContactsListAction() {
		return new ModelAndView("contacts/list-page","contacts",contactService.getAll());
	}
}
