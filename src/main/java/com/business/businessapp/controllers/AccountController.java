package com.business.businessapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.businessapp.entities.Account;
import com.business.businessapp.repositories.AccountRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	
	
	@GetMapping("/all")
	public List<Account> getAll() {
		return accountRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Account getAccountDetails(@PathVariable Long id) {
		return accountRepository.findById(id).get();
	}
	
}
