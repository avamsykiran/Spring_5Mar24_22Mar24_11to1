package com.cts.webdemo.model;

public class Visitor {

	private String title;
	private String fullName;
	private String mailId;
	
	public Visitor() {
		
	}

	public Visitor(String title, String fullName, String mailId) {
		super();
		this.title = title;
		this.fullName = fullName;
		this.mailId = mailId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	
}
