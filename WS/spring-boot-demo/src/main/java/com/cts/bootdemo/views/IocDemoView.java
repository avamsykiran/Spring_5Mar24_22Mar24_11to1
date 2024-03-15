package com.cts.bootdemo.views;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.bootdemo.services.Counter;
import com.cts.bootdemo.services.GreetService;

@Component
public class IocDemoView implements CommandLineRunner {
	
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
		
	public void run(String... args) throws Exception {
		
		System.out.println(appName);
		System.out.println("=======================================================================");
		System.out.println("Hello! this is our first console application based on spring boot!");
		
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
