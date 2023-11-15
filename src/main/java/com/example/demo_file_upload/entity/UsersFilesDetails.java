package com.example.demo_file_upload.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UsersFilesDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "displayname")
	private String displayname;

	@Column(name = "filename")
	private String filename;

	@ManyToOne
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private UserDetails userid;

	/* @return the field id */

	public int getId() {
		return id;
	}

	/* @param id set to the field id */

	public void setId(int id) {
		this.id = id;
	}

	/* @return the field displayname */

	public String getDisplayname() {
		return displayname;
	}

	/* @param displayname set to the field displayname */
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	/**
	 * @return the userid
	 */
	public UserDetails getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(UserDetails userid) {
		this.userid = userid;
	}

	/* @return the field filename */

	public String getFilename() {
		return filename;
	}

	/* @param filename set to the field filename */

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
