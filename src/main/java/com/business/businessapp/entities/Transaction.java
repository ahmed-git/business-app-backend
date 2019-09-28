package com.business.businessapp.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	public Transaction() {
		
	}
	
	public Transaction(Double amount, LocalDate transactionDate, TransactionStatus status, Account sender, Account receiver) {
		setAmount(amount);
		setTransactionDate(transactionDate);
		setStatus(status);
		setSender(sender);
		setReceiver(receiver);
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Double amount;
	
	@Column(columnDefinition = "DATE")
	private LocalDate transactionDate;
	
	@Enumerated(EnumType.STRING)
	private TransactionStatus status;
	
	@ManyToOne
	private Account sender;
	
	@ManyToOne
	private Account receiver;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public Account getSender() {
		return sender;
	}

	public void setSender(Account sender) {
		this.sender = sender;
	}

	public Account getReceiver() {
		return receiver;
	}

	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}
	
}
