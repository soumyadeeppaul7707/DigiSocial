package com.sp.digisocial.profile.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.digisocial.profile.bean.Post;
import com.sp.digisocial.profile.service.ProfileService;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {

	@Autowired
	public ProfileService profileService;
	
	@PostMapping("/profilepictureupload")
	public void fileUploadProcessProfilePicture(@RequestBody Post post) throws Throwable{
		profileService.fileUploadProcessProfilePicture(post);
	}
	
	@PostMapping("/showprofilepicture")
	public Post fileFetchProcessProfilePicture(@RequestBody Post post) throws Throwable{
		return profileService.fileFetchProcessProfilePicture(post);
	}
	
	@PostMapping("/postupload")
	public void fileUploadProcessPost(@RequestBody Post post) throws Throwable{
		profileService.fileUploadProcessPost(post);
	}
	
	@PostMapping("/showpost")
	public List<Post> fileFetchProcessPost(@RequestBody Post post) throws Throwable{
		return profileService.fileFetchProcessPost(post);
	}
}
