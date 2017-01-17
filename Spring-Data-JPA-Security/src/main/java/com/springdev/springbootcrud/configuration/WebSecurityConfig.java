package com.springdev.springbootcrud.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.springdev.springbootcrud.security.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = UserDetailServiceImpl.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
		
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	    authenticationProvider.setUserDetailsService(userDetailsService);
	    authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
	    return authenticationProvider;
	}
	
	  @Override
	 protected void configure(HttpSecurity http) throws Exception {
	     
		  http.authorizeRequests().antMatchers("/", "/list").access("hasRole('ADMIN') or hasRole('USER')"); 
		  
		  http.authorizeRequests()
		   .antMatchers("/registration/**", "/edit-user-*", "/update-user-*").access("hasRole('ADMIN')"); 
		  
		  
	      http.formLogin()
	      .loginPage("/login")
	      .loginProcessingUrl("/login")
	      .usernameParameter("username")
	      .passwordParameter("password");
	     
	      http.csrf()
	      .and().exceptionHandling().accessDeniedPage("/access-denied");
	
	    }


	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	 }
	
	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}
}
