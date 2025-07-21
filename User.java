package com.oracle.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;

	@Lob
	private String address;

	@Column(name="BANK_NAME")
	private String bankName;

	@Column(name="CARD_TYPE")
	private String cardType;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_AT")
	private LocalDate createdAt;

	//@Temporal(TemporalType.DATE)
	private LocalDate dob;

	private String email;

	@Column(name="IFSC_CODE")
	private String ifscCode;

	@Column(name="IS_ACTIVATED")
	private String isActivated;

	@Column(name="IS_VERIFIED")
	private String isVerified;

	private String name;

	private String password;

	private String phone;

	//@Temporal(TemporalType.DATE)
	@Column(name="REGISTRATION_DATE")
	private LocalDate registrationDate;

	private String salary;

	private String username;

	//bi-directional many-to-one association to Admin
	@OneToMany(mappedBy="user")
	private List<Admin> admins;

	//bi-directional many-to-one association to Card
	@OneToMany(mappedBy="user")
	private List<Card> cards;

	//bi-directional many-to-one association to Otp
	@OneToMany(mappedBy="user")
	private List<Otp> otps;

	//bi-directional many-to-one association to Purchas
	@OneToMany(mappedBy="user")
	private List<Purchas> purchases;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public LocalDate getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getDob() {
		return this.dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getIsActivated() {
		return this.isActivated;
	}

	public void setIsActivated(String isActivated) {
		this.isActivated = isActivated;
	}

	public String getIsVerified() {
		return this.isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Admin> getAdmins() {
		return this.admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public Admin addAdmin(Admin admin) {
		getAdmins().add(admin);
		admin.setUser(this);

		return admin;
	}

	public Admin removeAdmin(Admin admin) {
		getAdmins().remove(admin);
		admin.setUser(null);

		return admin;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Card addCard(Card card) {
		getCards().add(card);
		card.setUser(this);

		return card;
	}

	public Card removeCard(Card card) {
		getCards().remove(card);
		card.setUser(null);

		return card;
	}

	public List<Otp> getOtps() {
		return this.otps;
	}

	public void setOtps(List<Otp> otps) {
		this.otps = otps;
	}

	public Otp addOtp(Otp otp) {
		getOtps().add(otp);
		otp.setUser(this);

		return otp;
	}

	public Otp removeOtp(Otp otp) {
		getOtps().remove(otp);
		otp.setUser(null);

		return otp;
	}

	public List<Purchas> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(List<Purchas> purchases) {
		this.purchases = purchases;
	}

	public Purchas addPurchas(Purchas purchas) {
		getPurchases().add(purchas);
		purchas.setUser(this);

		return purchas;
	}

	public Purchas removePurchas(Purchas purchas) {
		getPurchases().remove(purchas);
		purchas.setUser(null);

		return purchas;
	}

}