package com.jhonnatha.sgc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.jhonnatha.sgc.security.UserSS;

public class UserAutenticationService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
