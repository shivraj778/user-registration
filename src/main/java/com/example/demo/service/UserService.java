package com.example.demo.service;

import com.example.demo.model.UserLogin;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hobby;
import com.example.demo.model.Info;
import com.example.demo.model.UserDetails;
import com.example.demo.repo.HobbyRepo;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private HobbyRepo hobbyRepo;
	
	public void add(Info info) {
		UserDetails user = new UserDetails();
		Hobby hobby = new Hobby();
		user.setFirstName(info.getFirstName());
		user.setLastName(info.getLastName());
		user.setEmail(info.getEmail());
		user.setPassword(info.getPassword());
		hobby.setHobby(info.getHobby());
		hobby.setEmail(info.getEmail());
		hobby.setDescription(info.getDescription());
		userRepo.save(user);
		hobbyRepo.save(hobby);
	}


	public Info getUser(UserLogin user) {
       UserDetails userDetails=userRepo.findByEmail(user.getEmail());
	   Hobby hobby = hobbyRepo.findByEmail(user.getEmail());
	   Info info = new Info();
	   info.setFirstName(userDetails.getFirstName());
	   info.setLastName(userDetails.getLastName());
	   info.setEmail(userDetails.getEmail());
	   info.setPassword("**********");
	   info.setHobby(hobby.getHobby());
	   info.setDescription(hobby.getDescription());
	   return info;
	}
}
