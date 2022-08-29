package com.mytv.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@NotNull
	@Column(name = "id")
	private int id;
	@NotNull
	@Column(name = "fname")
	private String fname;
	@Column(name = "lname")
	private String lname;
	@NotNull
	@Column(name="email")
	private String email;
	@NotNull
	@Column(name = "service")
	private String service;
	@NotNull
	@Column(name = "addedOn")
	private String addedOn;
	@Column(name = "updatedOn")
	private String updatedOn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmailId(String email) {
		this.email = email;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
}
