package com.example.myController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/home")
	String home(Model model){
		model.addAttribute("greeting", "Hello Dear");
		return "home";
	}
	
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public String getData(Model model) {		
		model.addAttribute("list", getList());
		return "index";
	}
	
	private List<String> getList() {
		
		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List E");
		
		return list;
	}
	
	
}
