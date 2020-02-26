package com.sp.digisocial.authenticate.service;


import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.digisocial.authenticate.bean.AuthenticationStatus;
import com.sp.digisocial.authenticate.bean.User;
import com.sp.digisocial.authenticate.repo.UserRepository;

@Service
public class AuthenticateServiceImpl implements AuthenticateService{

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public AuthenticationStatus loginUser(User loginUser) {
		AuthenticationStatus authenticate = new AuthenticationStatus();
		User user = userRepository.findByUsername(loginUser.getUsername());
		if (user != null) {
			if (user.getPassword().equals(loginUser.getPassword())) {
				authenticate.setAuthenticate(true);
				authenticate.setUser(user);
				authenticate.setMessage("Yayy!! Successfully loggen in...");
				authenticate.setLoginOrSignup("login");
			} else {
				authenticate.setAuthenticate(false);
				authenticate.setMessage("Nopes !! Incorrect credentials1 ...");
			}
		} else {
			authenticate.setAuthenticate(false);
			authenticate.setMessage("Nopes !! Incorrect credentials2 ...");
		}
		return authenticate;
	}

	@Transactional
	public AuthenticationStatus signupUser(User user) {
		AuthenticationStatus authenticate = new AuthenticationStatus();
		User user1 = userRepository.findByUsername(user.getUsername());
		if (user1 != null) {
			authenticate.setAuthenticate(false);
			authenticate.setMessage("User already exist. Kindly try with another username.");
		} else {
			userRepository.save(user);
			authenticate.setAuthenticate(true);
			authenticate.setMessage("Yayy! You Successfully Signed Up...");
			authenticate.setUser(user);
			authenticate.setLoginOrSignup("signup");

		}
		return authenticate;
	}

}
