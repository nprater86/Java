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

import dev.nathanprater.relationships.models.Dojo;
import dev.nathanprater.relationships.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	private final DojoService dojoService;
	
	public DojoController(DojoService s) {
		this.dojoService = s;
	}
	
	//Create a dojo
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/newDojo.jsp";
	}
	
	@PostMapping("")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	//Show a dojo
	@GetMapping("/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo",dojo);
		return "/dojos/showDojo.jsp";
	}
}
