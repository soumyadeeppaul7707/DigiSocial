package com.sp.digisocial.friendandchat.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.digisocial.friendandchat.bean.Friend;
import com.sp.digisocial.friendandchat.bean.User;
import com.sp.digisocial.friendandchat.service.FriendService;




@RestController
@RequestMapping("/friend")
@CrossOrigin(origins = "http://localhost:4200")
public class FriendController {

	
	private FriendService friendService;

	@Autowired
	private void setUserService(FriendService friendService) {
		this.friendService = friendService;
	}
	
	@PostMapping("/showfriendlist")
	public List<Friend> showFriendList(@RequestBody Friend friend){
		return friendService.showFriendList(friend);
	}
	
	@PostMapping("/unfrienduser")
	public void unfriendUser(@RequestBody Friend friend) {
		friendService.unfriendUser(friend);
	}
}
