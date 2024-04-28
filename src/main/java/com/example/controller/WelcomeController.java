package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.MessageBean;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
	
	public MessageBean getMessage() {
		
		return new MessageBean("welcome");
		
	}

}
