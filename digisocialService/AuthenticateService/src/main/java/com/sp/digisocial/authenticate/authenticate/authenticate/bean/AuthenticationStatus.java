package com.sp.digisocial.authenticate.authenticate.authenticate.bean;

public class AuthenticationStatus {
	
	private boolean authenticate;
	private User user;
	private String message;
	private String loginOrSignup;
	
	public boolean isAuthenticate() {
		return authenticate;
	}
	public void setAuthenticate(boolean authenticate) {
		this.authenticate = authenticate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLoginOrSignup() {
		return loginOrSignup;
	}
	public void setLoginOrSignup(String loginOrSignup) {
		this.loginOrSignup = loginOrSignup;
	}
	
	
	
}
