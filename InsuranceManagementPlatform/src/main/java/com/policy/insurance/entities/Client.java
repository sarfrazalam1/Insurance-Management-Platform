package com.policy.insurance.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	
	@Id 
	private int id;
	private String name;
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date DateOfBirth;
	private String address;
	private String phone;
	@Column(unique = true)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Policy policy;

	public Client(int id, String name, Date dateOfBirth, String address, String phone, String email, Policy policy) {
		super();
		this.id = id;
		this.name = name;
		DateOfBirth = dateOfBirth;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.policy = policy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", DateOfBirth=" + DateOfBirth + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", policy=" + policy + "]";
	}

	

}
