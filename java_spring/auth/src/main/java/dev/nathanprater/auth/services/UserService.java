package dev.nathanprater.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.nathanprater.auth.models.Role;
import dev.nathanprater.auth.models.User;
import dev.nathanprater.auth.repositories.RoleRepository;
import dev.nathanprater.auth.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public List<User> allUsers(){
    	return userRepository.findAll();
    }
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public void deleteById(Long id) {
    	userRepository.deleteById(id);
    }
    
    public User promoteUser(Long id) {
    	Optional<Role> optionalRole = roleRepository.findById(2L);
    	if(optionalRole.isPresent()) {
    		Role role = optionalRole.get();
    	} else {
    		return null;
    	}
    	Optional<User> optionalUser = userRepository.findById(id);
    	if(optionalUser.isPresent()) {
    		User user = optionalUser.get();
    		user.getRoles().add(role);
    		user.setIsAdmin(true);
    		return user;
    	} else {
    		return null;
    	}
    }
}
