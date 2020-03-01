package com.sp.digisocial.profile.rest;

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
	public void fileUploadProcess(@RequestBody Post post) throws Throwable{
		profileService.fileUploadProcess(post);
	}
}
