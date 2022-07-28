package com.nprater86;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/dojo")
	public String dojo() {
		return "The Dojo is awesome!";
	}
	
	@RequestMapping("/burbank-dojo")
	public String burbank() {
		return "Burbank Dojo is located in Southern California.";
	}
	
	@RequestMapping("/san-jose")
	public String sanjose() {
		return "SJ dojo is the headquarters.";
	}
}
