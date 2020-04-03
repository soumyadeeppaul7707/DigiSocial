package com.sp.digisocial.dashboardfriend.service;

import java.util.List;

import com.sp.digisocial.dashboardfriend.bean.Friend;
import com.sp.digisocial.dashboardfriend.bean.User;

public interface FriendService {
	public abstract List<User> userList(User user);
	public abstract void sendFriendRequest(Friend friend);
	public abstract List<Friend> friendRequestReceivedList(Friend friend);
	public abstract void acceptFriendRequest(Friend friend);
	public abstract void rejectFriendRequest(Friend friend);
}
