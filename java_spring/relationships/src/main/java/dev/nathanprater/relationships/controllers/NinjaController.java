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

import dev.nathanprater.relationships.models.Dojo;
import dev.nathanprater.relationships.models.Ninja;
import dev.nathanprater.relationships.services.DojoService;
import dev.nathanprater.relationships.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService n, DojoService d) {
		this.ninjaService = n;
		this.dojoService = d;
	}
	
	//create ninja
	@GetMapping("/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos",dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos",dojos);
			return "newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
