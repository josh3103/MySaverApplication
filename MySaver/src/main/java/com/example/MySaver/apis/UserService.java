package com.example.MySaver.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.MySaver.entities.User;
import com.example.MySaver.entities.user;
import com.example.MySaver.repository.UserRepository;

public class UserService {
	
	@Autowired
	User user;
	
	@Autowired
	UserRepository userRepository;
	
	@POST 
	@Path("/registerUser")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User registerOrUpdateUser(@BeanParam User user) {
	      user = userRepository.save(user);
	      System.out.println("Saver Account Registered "+user);
	      return user;
		        
	    }

}
