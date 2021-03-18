package com.springboot.web.springboot.first.application.web.service;

import org.springframework.stereotype.Component;

//Spring Bean
@Component
public class LoginService {
	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("chaitanya")
				&& password.equalsIgnoreCase("chaitanya");
	}
}

/* using stubs disadvantage 
*/