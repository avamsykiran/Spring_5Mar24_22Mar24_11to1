package com.cts.iocdemo.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceTimeBasedImpl implements GreetService {

	@Override
	public String greetUser(String userName) {
		String greeting="";
		
		int h = LocalTime.now().getHour();
		
		if(h>=5 && h<=11) greeting = "Good Morning";
		else if(h>11 && h<16) greeting = "Good Noon";
		else greeting= "Good Evening";
		
		return greeting + " " + userName;
	}

}
