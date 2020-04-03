package com.sp.digisocial.dashboardfriend.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user")
public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;
	
	
	@Id
	@Column(name = "us_username")
	private String username;
	
	
	@Column(name = "us_password")
	private String password;
	
	
	@Column(name = "us_email")
	private String email;
	
	
	@Column(name = "us_mobilenumber")
	private int mobilenumber;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-M-d HH:mm:ss", timezone = "Asia/Kolkata")
	@Column(name = "us_joiningdatetime")
	private Date joiningdatetime;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-M-d HH:mm:ss", timezone = "Asia/Kolkata")
	@Column(name = "us_dateofbirth")
	private Date dateofbirth;
	

	@Column(name = "us_firstname")
	private String firstname;
	

	@Column(name = "us_lastname")
	private String lastname;
	

	@Column(name = "us_middlename")
	private String middlename;
	
	
	@Transient
	private String currentuser;
	
	
	@Transient
	private boolean isfriend; 
	
	
	@Transient
	private char friendRequestStatus;
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(int mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getMiddlename() {
		return middlename;
	}


	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}


	public Date getJoiningdatetime() {
		return joiningdatetime;
	}


	public void setJoiningdatetime(Date joiningdatetime) {
		this.joiningdatetime = joiningdatetime;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getCurrentuser() {
		return currentuser;
	}


	public void setCurrentuser(String currentuser) {
		this.currentuser = currentuser;
	}


	public char getFriendRequestStatus() {
		return friendRequestStatus;
	}


	public void setFriendRequestStatus(char friendRequestStatus) {
		this.friendRequestStatus = friendRequestStatus;
	}


	public boolean isIsfriend() {
		return isfriend;
	}


	public void setIsfriend(boolean isfriend) {
		this.isfriend = isfriend;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", mobilenumber=" + mobilenumber + ", joiningdatetime=" + joiningdatetime + ", dateofbirth="
				+ dateofbirth + ", firstname=" + firstname + ", lastname=" + lastname + ", middlename=" + middlename
				+ ", currentuser=" + currentuser + ", isfriend=" + isfriend + ", friendRequestStatus="
				+ friendRequestStatus + "]";
	}

	
}
