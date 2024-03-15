package com.cts.bootdemo.views;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationView implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring Boot! ");
	}

}
