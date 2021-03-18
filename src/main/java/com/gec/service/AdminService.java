package com.gec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.model.User;
import com.gec.repository.UserRepo;

@Service
public class AdminService {

	@Autowired
	UserRepo userRepo;
	
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);

	}
	
	public void updateUserByMatricule(User newUser) {
		
		User old= userRepo.findByMatricule(newUser.getMatricule());
		old.setCreated_by(newUser.getCreated_by());
		old.setDirection(newUser.getDirection());
		old.setEmail(newUser.getEmail());
		old.setImage(newUser.getImage());
		old.setName(newUser.getName());
		old.setPassword(newUser.getPassword());
		old.setPhone(newUser.getPhone());
		old.setProfil(newUser.getProfil());
		userRepo.save(old);
		
	}
	
	public void createUser(User user) {
		userRepo.save(user);
	}
	
}