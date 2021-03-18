package com.gec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.gec.model.Login;
import com.gec.model.User;
import com.gec.service.UserService;

@RestController
@RequestMapping("/Login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@PostMapping("/connect")
	public  ResponseEntity<User> verifyUser(@Valid @RequestBody Login login) {
		User user = userService.login(login);
		
		if(user!=null) {
		if(user.getPassword().equals(login.getMdp())) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);}
	}
	
	

	
}
