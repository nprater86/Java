package dev.nathanprater.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.nathanprater.authentication.models.User;
import dev.nathanprater.authentication.services.UserService;
import dev.nathanprater.authentication.validator.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	
	private final UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator uV) {
        this.userService = userService;
        this.userValidator = uV;
    }
    
    //register user
    @GetMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @PostMapping(value="/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	// first validate user passwords
    	userValidator.validate(user, result);
        // if result has errors, return the registration page
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	} else {
    		// else, save the user in the database, save the user id in session, and redirect them to the /home route
    		User newUser = userService.registerUser(user);
    		session.setAttribute("loggedUser", newUser);
    		return "redirect:/home";
    	}
        
    }
    
    //user login
    @GetMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @PostMapping(value="/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
    	if(userService.authenticateUser(email, password)) {
    		User user = userService.findByEmail(email);
    		session.setAttribute("loggedUser", user);
    		return "redirect:/home";
    	} else {
    		// else, add error messages and return the login page
    		return "loginPage.jsp";
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
