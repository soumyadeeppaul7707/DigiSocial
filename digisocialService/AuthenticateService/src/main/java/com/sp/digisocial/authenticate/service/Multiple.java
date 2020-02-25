package com.sp.digisocial.authenticate.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.digisocial.authenticate.bean.AuthenticationStatus;
import com.sp.digisocial.authenticate.bean.User;
import com.sp.digisocial.authenticate.repo.UserRepository;

@Service
public class Multiple {

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public AuthenticationStatus loginUser(User loginUser) {
		// System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		// System.out.println(loginUser);
		// System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
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
			//System.out.println("joining date is -- >  "+user.getJoiningdatetime());
			//System.out.println("dob  date is -- >  "+user.getDateofbirth());
			//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
			//Date date = user.getJoiningdatetime();
			//System.out.println("joining date is -- >  "+dateFormat.format(date));
			System.out.println("Current sdqte is -----------------> "+ new Date());
			System.out.println("Joining date is -------------------------->"+user.getJoiningdatetime());
			System.out.println("date of birth is===============================>"+user.getDateofbirth());
			userRepository.save(user);
			authenticate.setAuthenticate(true);
			authenticate.setMessage("Yayy! You Successfully Signed Up...");
			authenticate.setUser(user);
			authenticate.setLoginOrSignup("signup");

		}
		return authenticate;
	}

}
