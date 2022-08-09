package dev.nathanprater.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import dev.nathanprater.authentication.models.User;
import dev.nathanprater.authentication.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository u) {
		this.userRepo = u;
	}
	
	//register user and hash password
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
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
	
	//authenticate user
	public boolean authenticateUser(String email, String password) {
		//first find user by email
		User user = userRepo.findByEmail(email);
		//if we can't find by email, return false
		if(user == null) {
			return false;
		} else {
			//if the passwords math, return true, else, return false
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
}
