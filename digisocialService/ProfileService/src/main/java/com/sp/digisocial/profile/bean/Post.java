package com.sp.digisocial.profile.bean;

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
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "po_id")
	private int id;


	@Column(name = "po_byusername")
	private String username;

	@Column(name = "po_caption")
	private String caption;

	@Column(name = "po_imagefilename")
	private String imagefilename;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-M-d HH:mm:ss", timezone = "Asia/Kolkata")
	@Column(name = "po_datetime")
	private Date uploadtime;

	@Column(name = "po_ispost")
	private boolean ispost;
	
	@Transient
	private String filename;
	
	@Transient
	private String blobobject;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImagefilename() {
		return imagefilename;
	}

	public void setImagefilename(String imagefilename) {
		this.imagefilename = imagefilename;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public boolean isIspost() {
		return ispost;
	}

	public void setIspost(boolean ispost) {
		this.ispost = ispost;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getBlobobject() {
		return blobobject;
	}

	public void setBlobobject(String blobobject) {
		this.blobobject = blobobject;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", username=" + username + ", caption=" + caption + ", imagefilename=" + imagefilename
				+ ", uploadtime=" + uploadtime + ", ispost=" + ispost + ", filename=" + filename + ", blobobject="
				+ blobobject + "]";
	}




}
