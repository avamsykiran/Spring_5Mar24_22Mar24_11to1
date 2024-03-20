package com.cts.webdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.webdemo.model.Loan;
import com.cts.webdemo.model.service.LoanService;

@Controller
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/loan")
	public ModelAndView showLoanPge() {
		return new ModelAndView("loan-page", "loan", new Loan());
	}
}
