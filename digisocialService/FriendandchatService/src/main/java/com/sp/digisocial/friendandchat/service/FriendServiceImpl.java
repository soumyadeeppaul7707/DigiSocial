package com.sp.digisocial.friendandchat.service;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.sp.digisocial.authenticate.bean.AuthenticationStatus;
import com.sp.digisocial.friendandchat.bean.User;
import com.sp.digisocial.friendandchat.repo.UserRepository;

@Service
public class FriendServiceImpl implements FriendService{

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public List<User> userList(User user){
		return userRepository.findByUsernameLike('%'+user.getUsername()+'%');
	}

}
