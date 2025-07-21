package com.oracle.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMI_PLANS database table.
 * 
 */
@Entity
@Table(name="EMI_PLANS")
@NamedQuery(name="EmiPlan.findAll", query="SELECT e FROM EmiPlan e")
public class EmiPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int duration;

	@Column(name="PROCESSING_FEE")
	private int processingFee;

	//bi-directional many-to-one association to Purchas
	@OneToMany(mappedBy="emiPlan")
	private List<Purchas> purchases;

	public EmiPlan() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getProcessingFee() {
		return this.processingFee;
	}

	public void setProcessingFee(int processingFee) {
		this.processingFee = processingFee;
	}

	public List<Purchas> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(List<Purchas> purchases) {
		this.purchases = purchases;
	}

	public Purchas addPurchas(Purchas purchas) {
		getPurchases().add(purchas);
		purchas.setEmiPlan(this);

		return purchas;
	}

	public Purchas removePurchas(Purchas purchas) {
		getPurchases().remove(purchas);
		purchas.setEmiPlan(null);

		return purchas;
	}

}