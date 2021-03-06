package com.sp.digisocial.friendandchat.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.digisocial.friendandchat.bean.Friend;
import com.sp.digisocial.friendandchat.repo.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService{

	@Autowired
	private FriendRepository friendRepository;

	
	@Transactional
	public List<Friend> showFriendList(Friend friend){
		return friendRepository.findByUsernameAndIsfriend(friend.getUsername(), true);
	}
	
	@Transactional
	public void unfriendUser(Friend friend) {
		friend = friendRepository.findByUsernameAndFriendname(
				friend.getUsername(), friend.getFriendname());
		friend.setIsfriend(false);
		friend.setFriendrequeststatus('u');
		friendRepository.save(friend);
		
		friend = friendRepository.findByUsernameAndFriendname(
				friend.getFriendname(), friend.getUsername());
		friend.setIsfriend(false);
		friend.setFriendrequeststatus('v');
		friendRepository.save(friend);
	}
}
