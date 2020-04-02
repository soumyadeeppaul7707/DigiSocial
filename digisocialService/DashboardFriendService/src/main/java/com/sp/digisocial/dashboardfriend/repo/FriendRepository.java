package com.sp.digisocial.dashboardfriend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.digisocial.dashboardfriend.bean.Friend;



@Repository
public interface FriendRepository extends JpaRepository<Friend, String>{

	//public List<User> findByUsernameLike(String username);
	
}
