package com.aniruddha.claim;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.aniruddha.insurancepolicy.InsurancePolicy;

@Entity
public class Claim {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String claimNumber;
	private Date date;
	private double amount;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="policy_id")
	private InsurancePolicy policy;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public InsurancePolicy getPolicy() {
		return policy;
	}
	public void setPolicy(InsurancePolicy policy) {
		this.policy = policy;
	}
	
	
	
	
	

}
