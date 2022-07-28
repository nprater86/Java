package com.nprater86.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HumanController {
	@RequestMapping("/")
	public String index(@RequestParam(required=false) Map<String, String> name, Model model) {
		if(name == null) {
			model.addAttribute("fName","John");
			model.addAttribute("lName","Doe");
		} else {
			if(name.get("fname") != null) {
				model.addAttribute("fName",name.get("fname"));
			} else {
				model.addAttribute("fName","John");
			}
			
			if(name.get("lname") != null) {
				model.addAttribute("lName",name.get("lname"));
			} else {
				model.addAttribute("lName","Doe");
			}
		}
		
		return "index.jsp";
	}
}
