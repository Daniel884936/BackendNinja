package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	private final String FORM_VIEW = "form";
	private final String RESULT_VIEW = "result";
	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
	
	
	@GetMapping("/showform")
	public ModelAndView showForm(Model model) {
		ModelAndView modelAndView = new ModelAndView(FORM_VIEW);
		modelAndView.addObject("person", new Person());
		return modelAndView;
	}
	
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		ModelAndView modelAndView = new ModelAndView(RESULT_VIEW);
		modelAndView.addObject("person", person);
		return modelAndView;
	}
}
