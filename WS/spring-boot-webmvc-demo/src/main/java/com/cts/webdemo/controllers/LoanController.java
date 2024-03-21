package com.cts.webdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.webdemo.model.Loan;
import com.cts.webdemo.model.service.LoanService;

@Controller
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping
	public ModelAndView showLoanPge() {
		return new ModelAndView("loan-page", "loan", new Loan());
	}
	
	@PostMapping
	public ModelAndView submittedLoanPge(@ModelAttribute("loan") Loan loan ) {
		return new ModelAndView("loan-page", "loan", loanService.computeEmi(loan));
	}
}
