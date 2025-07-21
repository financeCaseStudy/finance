package com.oracle.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "ADMIN" database table.
 * 
 */

@Entity
@Table(name="\"ADMIN\"")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_AT")
	private LocalDate createdAt;

	private String password;

	private String username;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Admin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}