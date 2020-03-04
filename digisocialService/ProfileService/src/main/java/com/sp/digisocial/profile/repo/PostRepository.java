package com.sp.digisocial.profile.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.digisocial.profile.bean.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

	public Post findById(int id);

	public List<Post> findByUsernameAndIspostOrderByUploadtimeDesc(String username,
			boolean ispost);

}
