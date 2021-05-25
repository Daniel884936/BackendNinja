package com.udemy.backendninja.controller;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.apache.commons.logging.Log;

import com.udemy.backendninja.component.IExampleComponent;
import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	private final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	
	private final String FORM_VIEW = "form";
	private final String RESULT_VIEW = "result";		
	private IExampleComponent _exampleComponent;  
	
	//injection from bean container 
	@Autowired
	public Example3Controller(IExampleComponent exampleComponent) {
		_exampleComponent = exampleComponent;
	}


	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
	
	
	@GetMapping("/showform")
	public ModelAndView showForm(Model model) {
		_exampleComponent.sayHello();
		ModelAndView modelAndView = new ModelAndView(FORM_VIEW);
		modelAndView.addObject("person", new Person());
		return modelAndView;
	}
	
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		LOGGER.info("METHOD: 'addPerson' --PARAMS: '"+person+"'");
		ModelAndView modelAndView = new ModelAndView(RESULT_VIEW);
		modelAndView.addObject("person", person);
		return modelAndView;
	}
}
