package dev.nathanprater.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		String weekday = new SimpleDateFormat("EEEE").format(date);
		String day = new SimpleDateFormat("d").format(date);
		String month = new SimpleDateFormat("MMMM").format(date);
		String year = new SimpleDateFormat("Y").format(date);
		String finalDate = weekday + ", the " + day + " of " + month + ", " + year;
		model.addAttribute("date",finalDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date time = new Date();
		String modifiedTime = new SimpleDateFormat("hh:mm a").format(time);
		
		model.addAttribute("time",modifiedTime);
		return "time.jsp";
	}
}
