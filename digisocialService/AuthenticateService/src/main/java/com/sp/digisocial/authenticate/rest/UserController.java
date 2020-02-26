package com.sp.digisocial.authenticate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.digisocial.authenticate.bean.AuthenticationStatus;
import com.sp.digisocial.authenticate.bean.User;
import com.sp.digisocial.authenticate.service.AuthenticateService;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	
	private AuthenticateService userService;

	@Autowired
	private void setUserService(AuthenticateService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public AuthenticationStatus loginUser(@RequestBody User user){
		return userService.loginUser(user);
	}

	@PostMapping("/signup")
	public AuthenticationStatus signupUser(@RequestBody User user){
		return userService.signupUser(user);
	}
	
	
}
