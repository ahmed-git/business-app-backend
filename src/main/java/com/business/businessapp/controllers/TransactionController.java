package com.business.businessapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.businessapp.entities.Transaction;
import com.business.businessapp.entities.TransactionAccountResponse;
import com.business.businessapp.entities.TransactionStatus;
import com.business.businessapp.repositories.TransactionRepository;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@GetMapping("/account/{id}")
	public List<TransactionAccountResponse> getTransactions(@PathVariable Long id) {
		return transactionRepository.findAllByAccountId(id);
	}
	
	@GetMapping("/all/{status}")
	public List<Transaction> getAll(@PathVariable String status) {
		return transactionRepository.findAllByStatus(TransactionStatus.valueOf(status.toUpperCase()));
	}
}
