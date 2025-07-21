package com.oracle.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CARDS database table.
 * 
 */
@Entity
@Table(name="CARDS")
@NamedQuery(name="Card.findAll", query="SELECT c FROM Card c")
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="CARD_NUMBER")
	private String cardNumber;

	@Column(name="CARD_TYPE")
	private String cardType;

	@Column(name="IS_ACTIVE")
	private String isActive;

	@Column(name="TOTAL_LIMIT")
	private int totalLimit;

	@Column(name="USED_CREDIT")
	private int usedCredit;

	//@Temporal(TemporalType.DATE)
	@Column(name="VALID_TILL")
	private LocalDate validTill;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Card() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getTotalLimit() {
		return this.totalLimit;
	}

	public void setTotalLimit(int totalLimit) {
		this.totalLimit = totalLimit;
	}

	public int getUsedCredit() {
		return this.usedCredit;
	}

	public void setUsedCredit(int usedCredit) {
		this.usedCredit = usedCredit;
	}

	public LocalDate getValidTill() {
		return this.validTill;
	}

	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}