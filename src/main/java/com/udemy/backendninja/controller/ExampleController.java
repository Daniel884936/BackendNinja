package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {

	private static final String EXAMPLE_VIEW = "example";
	
	//first way 
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}
	
	//Second way 
	@GetMapping("/exampleMAV")
	public ModelAndView exampleModel(){
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", getPeople());
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Daniel", 22));
		people.add(new Person("Jose", 30));
		people.add(new Person("Fernando", 40));
		people.add(new Person("Daniel", 52));
		return people;
	}
}
