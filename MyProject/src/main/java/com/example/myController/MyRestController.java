package com.example.myController;

import com.example.myModel.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myModel.Papagal;

@RestController
public class MyRestController {


	@RequestMapping(value="/papagalAsString", method=RequestMethod.GET)
	@ResponseBody
	public String printStraightString(){
		return "{\"msg\": \"success\"}";
	}
	
	@RequestMapping(value="/papagalAsJson", method=RequestMethod.GET)
	@ResponseBody
	public Papagal papagalAsJSON(){
		return new Papagal("Goshkko", 4, new Address("Sofiq", "SanStefano", 29));
	}
	
}
