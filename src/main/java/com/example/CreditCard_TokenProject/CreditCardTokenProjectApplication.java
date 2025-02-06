package com.example.CreditCard_TokenProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CreditCardTokenProjectApplication {
	@RequestMapping("/welcome")
	public String loginMessage(){
		return "welcome";
	}
	}

