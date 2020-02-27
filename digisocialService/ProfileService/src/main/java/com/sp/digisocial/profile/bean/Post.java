package com.sp.digisocial.profile.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.sp.digisocial.authenticate.bean.User;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "po_id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "po_byusername")
	private User user;

	@Column(name = "po_caption")
	private String caption;

	@Column(name = "po_imagefilename")
	private String imagefilename;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-M-d HH:mm:ss", timezone = "Asia/Kolkata")
	@Column(name = "po_datetime")
	private Date uploadtime;

	@Column(name = "po_ispost")
	private boolean ispostOrProfilepicture;
	
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

	public boolean isIspostOrProfilepicture() {
		return ispostOrProfilepicture;
	}

	public void setIspostOrProfilepicture(boolean ispostOrProfilepicture) {
		this.ispostOrProfilepicture = ispostOrProfilepicture;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", user=" + user + ", caption=" + caption + ", imagefilename=" + imagefilename
				+ ", uploadtime=" + uploadtime + ", ispostOrProfilepicture=" + ispostOrProfilepicture + ", filename="
				+ filename + ", blobobject=" + blobobject + "]";
	}

	

}
