package com.oracle.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TRANSACTIONS database table.
 * 
 */
@Entity
@Table(name="TRANSACTIONS")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="AMOUNT_PAID")
	private int amountPaid;

	@Column(name="MODE_OF_PAYMENT")
	private String modeOfPayment;

	//@Temporal(TemporalType.DATE)
	@Column(name="TRANSACTION_DATE")
	private LocalDate transactionDate;

	//bi-directional many-to-one association to Purchas
	@ManyToOne
	@JoinColumn(name="PURCHASE_ID")
	private Purchas purchas;

	public Transaction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getModeOfPayment() {
		return this.modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public LocalDate getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Purchas getPurchas() {
		return this.purchas;
	}

	public void setPurchas(Purchas purchas) {
		this.purchas = purchas;
	}

}