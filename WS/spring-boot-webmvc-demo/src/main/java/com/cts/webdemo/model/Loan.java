package com.cts.webdemo.model;

public class Loan {

	private double principal;
	private double rateOfInterest;
	private double timePeriod;
	private double emi;
	
	public Loan() {
		this.principal=1000;
		this.rateOfInterest=0.18;
		this.timePeriod=5;
		this.emi=25.39;
	}

	public Loan(double principal, double rateOfInterest, double timePeriod) {
		super();
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.timePeriod = timePeriod;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(double timePeriod) {
		this.timePeriod = timePeriod;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}
	
	
}
