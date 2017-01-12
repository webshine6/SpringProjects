package com.example.myController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.myModel.Address;

@Controller
@SessionAttributes(names="addresss")
public class AddressController {

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String prepareToAddress(Model model) {
		Address address = new Address();
		model.addAttribute("address", address); // = model.addAttribute(address);
		return "address";
	}
	
	@RequestMapping(value = "/address", method = RequestMethod.POST)
	public String addReadyAddress(@ModelAttribute Address address, Model model) {
		System.out.println(address);
		// add to DAO
		model.addAttribute("greeting", "Product added successfully");
		model.addAttribute(address);
		return "hello";
	}
	
	
}
