package com.springdev.springbootcrud.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springdev.springbootcrud.domains.Role;
import com.springdev.springbootcrud.domains.User;
import com.springdev.springbootcrud.services.RoleService;
import com.springdev.springbootcrud.services.UserService;

@Controller
public class AppController {

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	/*
	 * list all existing users.
	 */	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String listUsers(Model model) {
		
		List<User> users = userService.findAllUsers();	
		
		model.addAttribute("users", users);
		model.addAttribute("roles", roleService.findAll());
	    model.addAttribute("loggedinuser", getPrincipal());
		
		return "list-users";
	}
	
	
	
	
	@RequestMapping(value = "/registration")
	public String newUser(Model model) {
		User user = new User();
		
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "registration";
		}

		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getUsername() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/list";
	}
	
	/*
	 * update existing user
	 */
	@RequestMapping(value = "edit-user-{userid}", method = RequestMethod.GET)
	public String editUser(@PathVariable("userid") Long userid, Model model) {
		
		User foundUser = userService.findById(userid);
		
		model.addAttribute("user", foundUser);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "registration";
	}
	
	@RequestMapping(value = "edit-user-{userid}", method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,  @PathVariable("userid") Long userid, Model model) {
		
		if (result.hasErrors()) {
			return "registration";
		}
		
		userService.updateUser(user);
		model.addAttribute("success", "User " + user.getUsername() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "success";
	}
	
	@RequestMapping(value = "/delete-user-{userid}",method = RequestMethod.GET)
	public String deleteUser(@PathVariable ("userid") Long userid) {
		userService.deleteUserById(userid);
		return "redirect:/list";
	}
	
	
	// returns principal = logged-in user
	private String getPrincipal() {
		return SecurityContextHolder.getContext().getAuthentication().getName();		
	}
	
	@ModelAttribute("roles")
	public List<Role> initializeRoles() {
		return roleService.findAll();
	}
	
	@RequestMapping(value = "/access-denied", method=RequestMethod.GET)
	public String accessDenied(Model model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "access-denied";
	}	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
	    if (isCurrentAuthenticationAnonymous()) {
			return "login";
		}else {
			return "redirect:/list";
		}		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		return "redirect:/login?logout";
	}
	
	
	
	
	/**
	 * returns true if users is already authenticated [logged-in]
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}

	
}
