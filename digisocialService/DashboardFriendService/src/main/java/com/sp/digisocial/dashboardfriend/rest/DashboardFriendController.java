package com.sp.digisocial.dashboardfriend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.digisocial.dashboardfriend.bean.Friend;
import com.sp.digisocial.dashboardfriend.bean.User;
import com.sp.digisocial.dashboardfriend.service.FriendService;




@RestController
@RequestMapping("/friend")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardFriendController {

	
	private FriendService friendService;

	@Autowired
	private void setUserService(FriendService friendService) {
		this.friendService = friendService;
	}
	
	@PostMapping("/showusers")
	public List<User> userList(@RequestBody User user){
		return friendService.userList(user); 
	}
	
	@PostMapping("/sendrequest")
	public void sendFriendRequest(@RequestBody Friend friend) {
		friendService.sendFriendRequest(friend);
	}
	
	@PostMapping("/requestreceived")
	public List<Friend> friendRequestReceivedList(@RequestBody Friend friend){
		return friendService.friendRequestReceivedList(friend);
	}
	
	@PostMapping("/acceptfriendrequest")
	public void acceptFriendRequest(@RequestBody Friend friend) {
		friendService.acceptFriendRequest(friend);
	}
	
	@PostMapping("/rejectfriendrequest")
	public void rejectFriendRequest(@RequestBody Friend friend) {
		friendService.rejectFriendRequest(friend);
	}
}
