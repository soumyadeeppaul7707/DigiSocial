package com.sp.digisocial.friendandchat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.digisocial.friendandchat.bean.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public List<User> findByUsernameLike(String username);
	
}
