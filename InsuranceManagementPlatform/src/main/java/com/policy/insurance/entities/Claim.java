package com.policy.insurance.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="claims")
public class Claim {
	
	@Id
	private long claimNumber;
	@Column(length=500)
	private String description;
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date claimDate;
	private boolean claimStatus;
	
	
	public Claim(long claimNumber, String description, Date claimDate, boolean claimStatus) {
		super();
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
	}


	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getClaimNumber() {
		return claimNumber;
	}


	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getClaimDate() {
		return claimDate;
	}


	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}


	public boolean isClaimStatus() {
		return claimStatus;
	}


	public void setClaimStatus(boolean claimStatus) {
		this.claimStatus = claimStatus;
	}


	@Override
	public String toString() {
		return "Claim [claimNumber=" + claimNumber + ", description=" + description + ", claimDate=" + claimDate
				+ ", claimStatus=" + claimStatus + "]";
	}
	
	

}
