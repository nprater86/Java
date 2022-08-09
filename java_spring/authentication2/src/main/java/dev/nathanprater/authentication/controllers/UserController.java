package dev.nathanprater.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dev.nathanprater.authentication.models.LoginUser;
import dev.nathanprater.authentication.models.User;
import dev.nathanprater.authentication.services.UserService;
import dev.nathanprater.authentication.validator.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	 
    public UserController(UserService userService, UserValidator uV) {
        this.userService = userService;
    }
    
    //register user
    @GetMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @PostMapping(value="/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page
    	userService.register(user, result);
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	} else {
    		// else, save the user in the database, save the user id in session, and redirect them to the /home route
    		session.setAttribute("loggedUser", user);
    		return "redirect:/home";
    	}
        
    }
    
    //user login
    @GetMapping("/login")
    public String login(@ModelAttribute("LoginUser") LoginUser loginUser) {
        return "loginPage.jsp";
    }
    
    @PostMapping(value="/login")
    public String loginUser(@Valid @ModelAttribute("LoginUser") LoginUser loginUser, BindingResult result, HttpSession session) {
        User user = userService.login(loginUser, result);
        if(result.hasErrors()) {
        	return "loginPage.jsp";
        } else {
        	session.setAttribute("user", user);
        	return "redirect:/home";
        }
        
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
    	// get user from session, save them in the model and return the home page
        User user = (User) session.getAttribute("loggedUser");
        model.addAttribute("user", user);
        return "homePage.jsp";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/login";
    }
}
