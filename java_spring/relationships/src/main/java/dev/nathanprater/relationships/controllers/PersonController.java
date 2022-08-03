package dev.nathanprater.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.nathanprater.relationships.models.Person;
import dev.nathanprater.relationships.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	private final PersonService service;
	
	public PersonController(PersonService s) {
		this.service = s;
	}
	
	//Show Person
	@GetMapping("/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		Person person = service.findPerson(id);
		model.addAttribute("person",person);
		return "/licenses/showPerson.jsp";
	}
	
	//Create New Person
	@GetMapping("/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/licenses/newPerson.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "/licenses/newPerson.jsp";
		} else {
			service.createPerson(person);
			return "redirect:/persons/" + person.getId();
		}
	}
}
