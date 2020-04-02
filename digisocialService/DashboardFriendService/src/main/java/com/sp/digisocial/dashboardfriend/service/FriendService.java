package com.sp.digisocial.dashboardfriend.service;

import java.util.List;

import com.sp.digisocial.dashboardfriend.bean.Friend;
import com.sp.digisocial.dashboardfriend.bean.User;

public interface FriendService {
	//public abstract AuthenticationStatus loginUser(User loginUser);
	//public abstract AuthenticationStatus signupUser(User user);
	public abstract List<User> userList(User user);
	public abstract void sendFriendRequest(Friend friend);
}
