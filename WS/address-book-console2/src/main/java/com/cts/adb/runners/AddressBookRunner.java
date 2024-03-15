package com.cts.adb.runners;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.adb.entities.Contact;
import com.cts.adb.service.ContactService;

@Component
public class AddressBookRunner implements CommandLineRunner {

	@Autowired
	private Scanner kbScanner;
	
	@Autowired
	@Qualifier("contactServiceImplWithRepo")
	private ContactService contactService;
	
	@Autowired
	DateTimeFormatter formatter;
	
	@Autowired
	private AddressBookSearchView searchView;
	
	@Override
	public void run(String... args) throws Exception {
		String cmd = null;
		
		while(!"quit".equalsIgnoreCase(cmd)) {
			System.out.println("Cmd (add/search/delete/quit)? ");
			cmd = kbScanner.next().toLowerCase();
			
			switch(cmd) {
			case "add": doAdd(); break;
			case "delete": doDelete(); break;
			case "search": searchView.run(); break;
			case "quit":System.out.println("Application Terminated!! "); break;
			default: System.out.println("Unknown Command");
			}
		}
	}

	public void doAdd() {
		
		Contact contact = new Contact();
		System.out.println("FullName? ");
		contact.setFullName(kbScanner.next());
		System.out.println("Mobile: ");
		contact.setMobileNumber(kbScanner.next());
		System.out.println("MailId: ");
		contact.setMeilId(kbScanner.next());
		System.out.println("Date Of Birth (yyyy-MM-dd): ");
		contact.setDateOfBith(LocalDate.parse(kbScanner.next(), formatter));
		
		contactService.add(contact);
		System.out.println();
	}
	
	public void doDelete() {
		System.out.println("ContactId: ");
		int id = kbScanner.nextInt();
		contactService.deleteById(id);
		System.out.println("Contact Deleted!");
	}
	
}
