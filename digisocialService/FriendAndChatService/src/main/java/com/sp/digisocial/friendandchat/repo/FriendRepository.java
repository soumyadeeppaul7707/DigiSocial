package com.sp.digisocial.friendandchat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.digisocial.friendandchat.bean.Friend;



@Repository
public interface FriendRepository extends JpaRepository<Friend, String>{

	public List<Friend> findByUsernameAndIsfriend(String username, boolean isfriend);
	public Friend findByUsernameAndFriendname(String username, String friendname);
}
