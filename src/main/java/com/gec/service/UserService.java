package com.gec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.model.Login;
import com.gec.model.User;
import com.gec.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public User login(Login login) {
		return userRepo.findByMatricule(login.getMatricule());
	}
	
	
	

}
