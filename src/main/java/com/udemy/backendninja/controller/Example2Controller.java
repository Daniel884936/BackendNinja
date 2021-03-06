package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {
	private static final String EXAMPLE_VIEW2  = "example2";
	
	//first way
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(
	name = "name", 
	required = false,
	defaultValue = "Null") String name) {
		ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW2);
		modelAndView.addObject("name", name);
		return modelAndView;
	}
	
	//second way
	@GetMapping("/request2/{name}")
	public ModelAndView request2(@PathVariable("name") String name) {
		ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW2);
		modelAndView.addObject("name", name);
		return modelAndView;
	}
}
