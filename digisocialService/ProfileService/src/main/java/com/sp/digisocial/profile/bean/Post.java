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

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "po_id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "po_byusername")
	private String username;

	@Column(name = "po_caption")
	private String caption;

	@Column(name = "po_imagefilename")
	private String imagefilename;

	@Column(name = "po_datetime")
	private Date uploadtime;

	@Column(name = "po_ispost")
	private boolean ispostOrProfilepicture;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "Post [id=" + id + ", username=" + username + ", caption=" + caption + ", imagefilename=" + imagefilename
				+ ", uploadtime=" + uploadtime + ", ispostOrProfilepicture=" + ispostOrProfilepicture + "]";
	}

}
