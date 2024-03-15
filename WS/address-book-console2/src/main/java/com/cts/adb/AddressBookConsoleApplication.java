package com.cts.adb;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookConsoleApplication.class, args);
	}

	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}
	
	@Bean
	public DateTimeFormatter formatter() {
		return  DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}
}
