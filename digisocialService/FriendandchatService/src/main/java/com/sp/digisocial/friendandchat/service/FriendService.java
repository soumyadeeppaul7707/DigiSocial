package com.sp.digisocial.friendandchat.service;

import java.util.List;

import com.sp.digisocial.friendandchat.bean.User;

public interface FriendService {
	//public abstract AuthenticationStatus loginUser(User loginUser);
	//public abstract AuthenticationStatus signupUser(User user);
	public abstract List<User> userList(User user);
}
