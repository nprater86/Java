package dev.nathanprater.auth.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.nathanprater.auth.models.User;
import dev.nathanprater.auth.services.UserService;
import dev.nathanprater.auth.validator.UserValidator;

@Controller
public class UserController {
	private UserService userService;
	private UserValidator userValidator;
	
	public UserController(UserService u, UserValidator uV) {
		this.userService = u;
		this.userValidator = uV;
	}
	
	//home
	@GetMapping({"/","/home"})
	public String home(Principal principal, Model model) {
		String username = principal.getName();
		User user = userService.findByUsername(username);
		
		model.addAttribute("currentUser", user);
		return "homePage.jsp";
	}
	
	//registration
	@GetMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
		if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        
		List<User> allUsers = userService.allUsers();
		if(allUsers.stream().anyMatch(u -> u.getIsAdmin() == true)) {
			user.setIsAdmin(false);
			userService.saveWithUserRole(user);
		} else {
			user.setIsAdmin(true);
			userService.saveUserWithAdminRole(user);
		}
		
        return "redirect:/";
    }
	
	@GetMapping("/admin")
	public String adminPage(Principal principal, Model model) {
		String username = principal.getName();
		List<User> allUsers = userService.allUsers();
		model.addAttribute("currentUser", userService.findByUsername(username));
		model.addAttribute("allUsers", allUsers);
		return "adminPage.jsp";
	}
    
	//login and logout
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		if(error != null) {
			model.addAttribute("errorMessage","Invalid Credientials, Please try again.");
		}
		
		if(logout != null) {
			model.addAttribute("logoutMessage","Logout Successful!");
		}
		return "loginPage.jsp";
	}
	
	//delete user
	@PostMapping("/admin/delete/{id}")
	public String deleteUser(@PathVariable(value="id") Long id) {
		userService.deleteById(id);
		return "redirect:/admin";
	}
}
