package com.cts.webdemo.model.service;

import org.springframework.stereotype.Service;

import com.cts.webdemo.model.Loan;

@Service
public class LoanServiceImpl implements LoanService {

	@Override
	public Loan computeEmi(Loan loan) {

		double principal = loan.getPrincipal();
		double rateOfInterest = loan.getRateOfInterest();
		double timePeriod = loan.getTimePeriod();

		double monthlyRate = rateOfInterest / 12d;

		double emi = (principal * monthlyRate * (Math.pow(1 + monthlyRate, timePeriod))
				/ (Math.pow(1 + monthlyRate, timePeriod) - 1));

		loan.setEmi(emi);

		return loan;
	}

}
