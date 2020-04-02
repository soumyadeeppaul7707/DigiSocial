package com.sp.digisocial.dashboardfriend.service;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.digisocial.dashboardfriend.bean.Friend;
//import com.sp.digisocial.authenticate.bean.AuthenticationStatus;
import com.sp.digisocial.dashboardfriend.bean.User;
import com.sp.digisocial.dashboardfriend.repo.FriendRepository;
import com.sp.digisocial.dashboardfriend.repo.UserRepository;

@Service
public class FriendServiceImpl implements FriendService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FriendRepository friendRepository;

//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	@Transactional
	public List<User> userList(User user){
		return userRepository.findByUsernameLike('%'+user.getUsername()+'%');
	}

	@Transactional
	public void sendFriendRequest(Friend friend) {
		Friend revFriend = new Friend();
		
		friend.setFriend(false);
		friend.setFriendRequestStatus('s');
		
		revFriend.setFriend(false);
		revFriend.setUsername(friend.getFriendname());
		revFriend.setFriendname(friend.getUsername());
		revFriend.setFriendRequestStatus('r');
		
		friendRepository.save(friend);
		friendRepository.save(revFriend);
		
	}
}
