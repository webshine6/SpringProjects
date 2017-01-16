package com.springdev.springbootcrud.security;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdev.springbootcrud.domains.User;
import com.springdev.springbootcrud.services.UserService;
import com.springdev.springbootcrud.domains.Role;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
		
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	
	@Autowired
	private UserService userService;
	
	@Override	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //---------------------------------------------------------------
		//--------------------Load user by username-----------------------
		User user = userService.findByUsername(username);	
		LOGGER.info("user: {}" + user);
		
		if (user == null) {
			LOGGER.info("User not found.");
			throw new UsernameNotFoundException("Username not found");	
		}
		
		//-----------------------------------------------------------------
		// ------------------- Load user granted authorities ---------------
					
		Set<Role> userRoles = user.getRoles();
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		for (Role role : userRoles) {
			LOGGER.info("Role: {} " + role);
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getType()));
		}
		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}
	
	
	
	
}	


