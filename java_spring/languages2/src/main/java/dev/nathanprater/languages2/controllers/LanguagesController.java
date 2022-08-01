package dev.nathanprater.languages2.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.nathanprater.languages2.models.Language;
import dev.nathanprater.languages2.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguagesController {
private final LanguageService langService;
	
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	
	@GetMapping("")
	public String index(Model model) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute(languages);
		return "index.jsp";
	}
}
