package com.sp.digisocial.friendandchat.service;

import java.util.List;

import com.sp.digisocial.friendandchat.bean.Friend;
import com.sp.digisocial.friendandchat.bean.User;

public interface FriendService {
	
	public abstract List<Friend> showFriendList(Friend friend);
}
