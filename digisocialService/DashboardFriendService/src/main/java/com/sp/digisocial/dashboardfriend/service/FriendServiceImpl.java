package com.sp.digisocial.dashboardfriend.service;


import java.util.ArrayList;
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
		List<User> usersList = new ArrayList<User>();
		usersList = userRepository.findByUsernameLike('%'+user.getUsername()+'%');
		usersList.forEach((userObj)-> setUserForUserList(user,userObj));
		return usersList;
	}
	
	public void setUserForUserList(User user,User frienduser) {
		Friend friend = friendRepository.findByUsernameAndFriendname(
				user.getCurrentuser(), frienduser.getUsername());
		frienduser.setFriendRequestStatus('0');
		if( friend != null) {
			frienduser.setIsfriend(friend.isIsfriend());
			frienduser.setFriendRequestStatus(friend.getFriendrequeststatus());
		}
	}

	
	
	@Transactional
	public void sendFriendRequest(Friend friend) {
		Friend revFriend = new Friend();
		
		if(friendRepository.findByUsernameAndFriendname(
				friend.getUsername(), friend.getFriendname())!=null ) {
			friend = friendRepository.findByUsernameAndFriendname(
					friend.getUsername(), friend.getFriendname());
			revFriend = friendRepository.findByUsernameAndFriendname(
					 friend.getFriendname(), friend.getUsername());
		}
		
		friend.setIsfriend(false);
		friend.setFriendrequeststatus('s');
		
		revFriend.setIsfriend(false);
		revFriend.setUsername(friend.getFriendname());
		revFriend.setFriendname(friend.getUsername());
		revFriend.setFriendrequeststatus('r');
		
		friendRepository.save(friend);
		friendRepository.save(revFriend);
		
	}
	
	
	@Transactional
	public List<Friend> friendRequestReceivedList(Friend friend){
		return friendRepository.findByUsernameAndFriendrequeststatus(
				friend.getUsername(), friend.getFriendrequeststatus());
	}
	
	@Transactional
	public void acceptFriendRequest(Friend friend) {
		friend = friendRepository.findByUsernameAndFriendname(
				friend.getUsername(), friend.getFriendname());
		friend.setIsfriend(true);
		friend.setFriendrequeststatus('a');
		friendRepository.save(friend);
		
		friend = friendRepository.findByUsernameAndFriendname(
				friend.getFriendname(), friend.getUsername());
		friend.setIsfriend(true);
		friend.setFriendrequeststatus('y');
		friendRepository.save(friend);
	}
	
	@Transactional
	public void rejectFriendRequest(Friend friend) {
		friend = friendRepository.findByUsernameAndFriendname(
				friend.getUsername(), friend.getFriendname());
		friend.setIsfriend(false);
		friend.setFriendrequeststatus('d');
		friendRepository.save(friend);
		
		friend = friendRepository.findByUsernameAndFriendname(
				friend.getFriendname(), friend.getUsername());
		friend.setIsfriend(false);
		friend.setFriendrequeststatus('n');
		friendRepository.save(friend);
	}
}
