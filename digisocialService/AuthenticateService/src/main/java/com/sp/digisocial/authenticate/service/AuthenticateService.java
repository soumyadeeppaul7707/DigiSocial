package com.sp.digisocial.authenticate.service;

import com.sp.digisocial.authenticate.bean.AuthenticationStatus;
import com.sp.digisocial.authenticate.bean.User;

public interface AuthenticateService {
	public abstract AuthenticationStatus loginUser(User loginUser);
	public abstract AuthenticationStatus signupUser(User user);
}
