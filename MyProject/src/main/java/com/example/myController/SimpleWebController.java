package com.example.myController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.myModel.Customer;;



@Controller
public class SimpleWebController {

	
	/**
	 * Get Customer Form
	 */
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String customerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "form";
	}
	
	
	/**
	 * Submit Customer Form
	 */
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String customerSubmit(@ModelAttribute Customer customer, Model model) {
		model.addAttribute("customer", customer);	
		return "result";
	}
	
}
