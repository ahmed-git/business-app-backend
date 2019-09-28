package com.business.businessapp.entities;

import java.time.LocalDate;

/** 
 * Used to return transaction details for an account
 */
public class TransactionAccountResponse {

	public TransactionAccountResponse() {
		
	}
	
	public TransactionAccountResponse(LocalDate date, Double amount, String company) {
		setAmount(amount);
		setCompany(company);
		setDate(date);
	}
	private Double amount;
	private String company;
	private LocalDate date;
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

}
