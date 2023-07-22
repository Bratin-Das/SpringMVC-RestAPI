package com.NoobCoders.service;

public class GreetingService {
	public String getMessage(String name) {
		if(name == null) {
			name = "WEB MVC";
		}
		return "Hello, " + name + "!!";
	}
}
