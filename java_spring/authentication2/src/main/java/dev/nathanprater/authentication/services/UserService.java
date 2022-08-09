package dev.nathanprater.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import dev.nathanprater.authentication.models.LoginUser;
import dev.nathanprater.authentication.models.User;
import dev.nathanprater.authentication.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	public UserService(UserRepository uR) {
		this.userRepo = uR;
	}
	
	//register user and hash password
	public User register(User newUser, BindingResult result) {
		//check to see if user email already exists
        if(userRepo.findByEmail(newUser.getEmail()) != null) {
            result.rejectValue("email", "Unique", "This email is already in use");
        }
        //check to make sure passwords match
        if(!newUser.getPassword().equals(newUser.getPasswordConfirmation())) {
            result.rejectValue("passwordConfirmation", "Matches", "Passwords do not match");
        }
        //if there are errors then return null
        if(result.hasErrors()) {
            return null;
        } else {
        	//otherwise, hash password and save user to database
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }
	
	//find user by email
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	//find user by id
	public User findUserById(Long id) {
		Optional<User> u = userRepo.findById(id);
		
		if(u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
	
	//login user
	public User login(LoginUser newLogin, BindingResult result) {
		//if there are errors on the form, return null
        if(result.hasErrors()) {
            return null;
        }
        //grab user if no errors
        User user = userRepo.findByEmail(newLogin.getEmail());
        //if user email doesn't exist
        if(user == null) {
            result.rejectValue("email", "Unique", "Invalid email/password");
            return null;
        }
        //check password
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid email/password");
        }
        //if there are any more errors, return null
        if(result.hasErrors()) {
            return null;
        } else {
        	//otherwise, return the user
            return user;
        }
    }
	
}
