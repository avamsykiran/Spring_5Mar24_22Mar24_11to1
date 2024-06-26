package com.cts.iocdemo.views;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.iocdemo.service.Counter;
import com.cts.iocdemo.service.GreetService;

@Component
public class IocDemoView {
	
	@Value("${app.name:UnNamed Application}")
	private String appName;
	
	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("greetServiceTimeBasedImpl")
	private GreetService greetService2;

	@Autowired
	private GreetService greetService3;
	
	@Autowired
	private Counter counter1;
	
	@Autowired
	private Counter counter2;
	
	@Autowired
	private Scanner kbScanner;
		
	public void run() {
		
		System.out.println(appName);
		System.out.println("=======================================================================");
		System.out.println("Hello! this is our first console application based on spring framework!");
		
		System.out.println("UserName? ");
		String unm = kbScanner.nextLine();
		
		System.out.println(greetService1.greetUser(unm));
		System.out.println(greetService2.greetUser(unm));
		System.out.println(greetService3.greetUser(unm));
		
		System.out.println("From counter1: "+counter1.next());
		System.out.println("From counter1: "+counter1.next());
		System.out.println("From counter1: "+counter1.next());
		System.out.println("From counter2: "+counter2.next());
		System.out.println("From counter2: "+counter2.next());
		System.out.println("From counter2: "+counter2.next());		
		
	}
}
