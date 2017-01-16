package com.springdev.springbootcrud.security;


public interface SecurityService {
	
	//  provide current logged in user
	String findLoggedInUsername();

	// auto login user after registering an account
    void autologin(String username, String password);
}
