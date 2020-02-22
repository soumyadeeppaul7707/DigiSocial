package com.sp.digisocial.authenticate.authenticate.authenticate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.digisocial.authenticate.authenticate.authenticate.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findById(int id);

	public User findByUsername(String username);
	
	public User findByPassword(String password);

}
