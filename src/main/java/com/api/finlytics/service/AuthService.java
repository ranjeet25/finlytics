package com.api.finlytics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.finlytics.model.User;
import com.api.finlytics.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	public boolean login(String username, String password) {
		
	User user = userRepository.findByUsername(username);
		
		if (user!= null && user.getPassword().equals(password))
			return true;
		
		return false;
	}
	
	  public String register(String username, String password, String email) {
	    	
	    	User exist = userRepository.findByUsername(username);
	    	
	    	if(exist!=null) return "User already exists";
	    	
	    	User user= new User();
	    	
	    	user.setUsername(username);
	    	user.setEmail(email);
	    	user.setPassword(password);
	    	
	    	userRepository.save(user);
	    	
	    	return "User Registered Successfully";
	    }
}
