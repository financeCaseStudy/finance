package com.oracle.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the OTPS database table.
 * 
 */
@Entity
@Table(name="OTPS")
@NamedQuery(name="Otp.findAll", query="SELECT o FROM Otp o")
public class Otp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_AT")
	private Date createdAt;

	@Column(name="IS_VERIFIED")
	private String isVerified;

	@Column(name="OTP_CODE")
	private String otpCode;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Otp() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getIsVerified() {
		return this.isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}

	public String getOtpCode() {
		return this.otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}