package com.business.businessapp.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.MANAGER)
public class Manager extends Person{

	public Manager() {
		super();
	}
	
	public Manager(String firstName, String lastName, Boolean status, String email, 
			String phone, Company company, LocalDate updated,
			Double approval) {
		super(firstName, lastName, status, email, phone, company, updated);
		setApproval(approval);
	}
	private Double approval;

	public Double getApproval() {
		return approval;
	}

	public void setApproval(Double approval) {
		this.approval = approval;
	}
	
	
	
}
