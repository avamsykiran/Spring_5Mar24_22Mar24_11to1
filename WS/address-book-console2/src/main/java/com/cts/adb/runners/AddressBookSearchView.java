package com.cts.adb.runners;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cts.adb.entities.Contact;
import com.cts.adb.service.ContactService;

@Component
public class AddressBookSearchView {

	@Autowired
	private Scanner kbScanner;
	
	@Autowired
	@Qualifier("contactServiceImplWithRepo")
	private ContactService contactService;
	
	@Autowired
	DateTimeFormatter formatter;
	
	public void run() {
		String cmd = null;
		
		while(!"back".equalsIgnoreCase(cmd)) {
			System.out.println("Cmd (all/mobile/mail/birth/back)? ");
			cmd = kbScanner.next().toLowerCase();
			
			switch(cmd) {
			case "all":doList(); break;
			case "mobile":doSearchByMobile(); break;
			case "mail":doSearchByMail(); break;
			case "birth":doSearchByBirth(); break;
			default: System.out.println("Unknown Command");
			}
		}
	}
	
	void doList() {
		display(contactService.getAll());
	}

	void doSearchByMobile() {
		System.out.println("Mobile Number? ");
		String mobileNumber = kbScanner.next();
		Contact contact = contactService.getByMobileNumber(mobileNumber);
		display(contact!=null?Collections.singletonList(contact):null);
	}

	void doSearchByMail() {
		System.out.println("Mail Id? ");
		String mailId = kbScanner.next();
		Contact contact = contactService.getByMailId(mailId);
		display(contact!=null?Collections.singletonList(contact):null);
	}

	void doSearchByBirth() {
		System.out.println("Start Date? ");
		LocalDate start = LocalDate.parse(kbScanner.next(), formatter);
		System.out.println("End Date? ");
		LocalDate end = LocalDate.parse(kbScanner.next(), formatter);
		display(contactService.getAllBornBetween(start, end));
	}
	
	void display(List<Contact> contacts) {
		if(contacts==null || contacts.isEmpty()) {
			System.out.println("No contacts recorded as of now");
		}else {
			contacts.stream().forEach(System.out::println);
		}
	}
}