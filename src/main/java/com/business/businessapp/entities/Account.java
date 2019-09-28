package com.business.businessapp.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	public Account() {
		
	}
	
	public Account(String iban, Double availibility, String bank, Company company, LocalDate lastUpdated) {
		setAccount(iban);
		setAvailibility(availibility);
		setBank(bank);
		setCompany(company);
		setLastUpdated(lastUpdated);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String account;
	
	@Column(nullable = false)
	private String bank;
	
	@ManyToOne
	private Company company;
	
	@Column(scale = 2, nullable = false)
	private Double availibility;
	
	@Column(columnDefinition = "DATE", nullable = false)
	private LocalDate lastUpdated;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company owner) {
		this.company = owner;
	}

	public Double getAvailibility() {
		return availibility;
	}

	public void setAvailibility(Double availibility) {
		this.availibility = availibility;
	}

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
}
