package com.cts.iocdemo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GreetServiceSimpleImpl implements GreetService {

	@Override
	public String greetUser(String userName) {
		return "Hello " + userName;
	}

}
