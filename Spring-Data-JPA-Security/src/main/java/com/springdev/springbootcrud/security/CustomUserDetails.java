package com.springdev.springbootcrud.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.springdev.springbootcrud.domains.Role;
import com.springdev.springbootcrud.domains.User;

public class CustomUserDetails extends User implements UserDetails {

	private static final long serialVersionUID = 1L;
    private Set<Role> userRoles;
	
    public CustomUserDetails(String username, String password, Set<Role> roles) {
    	super(username, password);
		this.userRoles = roles;
	}
    
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
		
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
