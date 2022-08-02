package dev.nathanprater.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.nathanprater.relationships.models.License;
import dev.nathanprater.relationships.models.Person;
import dev.nathanprater.relationships.services.LicenseService;
import dev.nathanprater.relationships.services.PersonService;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicenseController(LicenseService s, PersonService p) {
		this.licenseService = s;
		this.personService = p;
	}
	
	//Create New License
	@GetMapping("/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons",persons);
		return "newLicense.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Person> persons = personService.allPersons();
			model.addAttribute("persons",persons);
			return "newLicense.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/licenses/new";
		}
	}
}
