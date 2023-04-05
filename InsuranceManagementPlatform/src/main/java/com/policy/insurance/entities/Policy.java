package com.policy.insurance.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="policies")
public class Policy {
	
	@Id
	private int policyNumber;
	private double policyCoverageAmount;
	private String policyType;
	private String policyPremium;
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date policyStartDate;
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date policyEndDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Claim claim;

	public Policy(int policyNumber, double policyCoverageAmount, String policyType, String policyPremium,
			Date policyStartDate, Date policyEndDate, Claim claim) {
		super();
		this.policyNumber = policyNumber;
		this.policyCoverageAmount = policyCoverageAmount;
		this.policyType = policyType;
		this.policyPremium = policyPremium;
		this.policyStartDate = policyStartDate;
		this.policyEndDate = policyEndDate;
		this.claim = claim;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public double getPolicyCoverageAmount() {
		return policyCoverageAmount;
	}

	public void setPolicyCoverageAmount(double policyCoverageAmount) {
		this.policyCoverageAmount = policyCoverageAmount;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(String policyPremium) {
		this.policyPremium = policyPremium;
	}

	public Date getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public Date getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", policyCoverageAmount=" + policyCoverageAmount
				+ ", policyType=" + policyType + ", policyPremium=" + policyPremium + ", policyStartDate="
				+ policyStartDate + ", policyEndDate=" + policyEndDate + ", claim=" + claim + "]";
	}
	
	

}
