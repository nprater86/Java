package dev.nathanprater.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.nathanprater.languages.models.Language;
import dev.nathanprater.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguagesController {
	private final LanguageService langService;
	
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	
	@GetMapping("")
	public String index(Model model, @ModelAttribute("language") Language lang) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages",languages);
		return "index.jsp";
	}
	
	//CREATE ROUTE
	@PostMapping("")
	public String create(Model model, @Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			List<Language> languages = langService.allLanguages();
			model.addAttribute("languages",languages);
			return "index.jsp";
		} else {
			langService.createLanguage(lang);
			return "redirect:/languages";
		}
	}
	
	//EDIT ROUTES	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLanguage(id);
		model.addAttribute("language",lang);
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			langService.updateLanguage(lang);
			return "redirect:/languages";
		}
	}
	
	//DELETE ROUTE
	@DeleteMapping("/{id}")
	public String destroy(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
