package dev.nathanprater.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submitSurvey", method=RequestMethod.POST)
	public String submitSurvey(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment",required=false) String comment, RedirectAttributes flash, HttpSession session) {
		if(name.equals("") || location.equals("") || language.equals("")) {
			if(name.equals("")) {
				flash.addFlashAttribute("nameError","Please enter your name.");
			}
			
			if(location.equals("")) {
				flash.addFlashAttribute("locationError","Please select your location.");
			}
			
			if(language.equals("")) {
				flash.addFlashAttribute("languageError","Please select your favorite language.");
			}
			
			return "redirect:/";
		} else {
			session.setAttribute("name", name);
			session.setAttribute("location", location);
			session.setAttribute("language", language);
			session.setAttribute("comment", comment);
			
			return "redirect:/results";
		}
	}
	
	@RequestMapping("/results")
	public String results(HttpSession session, Model model) {
		if(session.getAttribute("name") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("name", (String) session.getAttribute("name"));
		model.addAttribute("location", (String) session.getAttribute("location"));
		model.addAttribute("language", (String) session.getAttribute("language"));
		model.addAttribute("comment", (String) session.getAttribute("comment"));
		return "results.jsp";
	}
}
