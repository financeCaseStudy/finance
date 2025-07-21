package com.oracle.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PURCHASES database table.
 * 
 */
@Entity
@Table(name="PURCHASES")
@NamedQuery(name="Purchas.findAll", query="SELECT p FROM Purchas p")
public class Purchas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="AMOUNT_PAID")
	private int amountPaid;

	@Column(name="MONTHLY_EMI")
	private int monthlyEmi;

	//@Temporal(TemporalType.DATE)
	@Column(name="NEXT_DUE_DATE")
	private LocalDate nextDueDate;

	//@Temporal(TemporalType.DATE)
	@Column(name="PURCHASE_DATE")
	private LocalDate purchaseDate;

	private String status;

	@Column(name="TOTAL_AMOUNT")
	private int totalAmount;

	//bi-directional many-to-one association to EmiPlan
	@ManyToOne
	@JoinColumn(name="PLAN_ID")
	private EmiPlan emiPlan;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="purchas")
	private List<Transaction> transactions;

	public Purchas() {
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

	public int getMonthlyEmi() {
		return this.monthlyEmi;
	}

	public void setMonthlyEmi(int monthlyEmi) {
		this.monthlyEmi = monthlyEmi;
	}

	public LocalDate getNextDueDate() {
		return this.nextDueDate;
	}

	public void setNextDueDate(LocalDate nextDueDate) {
		this.nextDueDate = nextDueDate;
	}

	public LocalDate getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public EmiPlan getEmiPlan() {
		return this.emiPlan;
	}

	public void setEmiPlan(EmiPlan emiPlan) {
		this.emiPlan = emiPlan;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setPurchas(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setPurchas(null);

		return transaction;
	}

}