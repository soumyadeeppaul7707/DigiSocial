package com.sp.digisocial.dashboardfriend.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="friend")
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fr_id")
	private int id;
	
	@Column(name = "fr_us_username")
	private String username;
	
	@Column(name = "fr_us_fr_username")
	private String friendname;
	
	
	@Column(name = "fr_isfriend")
	private boolean isFriend;
	
	@Column(name = "fr_req_send_accept_declined")
	private char friendRequestStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFriendname() {
		return friendname;
	}

	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}

	public boolean isFriend() {
		return isFriend;
	}

	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}

	public char getFriendRequestStatus() {
		return friendRequestStatus;
	}

	public void setFriendRequestStatus(char friendRequestStatus) {
		this.friendRequestStatus = friendRequestStatus;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", username=" + username + ", friendname=" + friendname + ", isFriend=" + isFriend
				+ ", friendRequestStatus=" + friendRequestStatus + "]";
	}
	
	
	
	
}
