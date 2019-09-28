package com.business.businessapp.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.ACCOUNTANT)
public class Accountant extends Person {

	public Accountant() {
		super();
	}
	
	public Accountant(String firstName, String lastName, Boolean status, String email, 
			String phone, Company company, LocalDate updated,
			int invoices, int companies) {
		super(firstName, lastName, status, email, phone, company, updated);
		setInvoices(invoices);
		setCompanies(companies);
	}
	
	private int invoices;
	
	private int companies;

	public int getInvoices() {
		return invoices;
	}

	public void setInvoices(int invoices) {
		this.invoices = invoices;
	}

	public int getCompanies() {
		return companies;
	}

	public void setCompanies(int companies) {
		this.companies = companies;
	}
	
	
}
