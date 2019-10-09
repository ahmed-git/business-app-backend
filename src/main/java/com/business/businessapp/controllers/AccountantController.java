package com.business.businessapp.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.businessapp.entities.Accountant;
import com.business.businessapp.entities.Company;
import com.business.businessapp.repositories.AccountantRepository;

@RestController
@RequestMapping("/accountant")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountantController {

	@Autowired
	private AccountantRepository accountantRepository;
	
	@GetMapping("/all")
	public List<Accountant> getAll() {
		return accountantRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Accountant get(@PathVariable Long id) {
		return accountantRepository.findById(id).get();
	}
	
	@PostMapping("/{id}") 
	public void save(@RequestBody Accountant accountant) {
		Company company = new Company();
		company.setId(accountant.getCompany().getId());
		accountant.setCompany(company);
		accountant.setLastModified(LocalDate.now());
		accountantRepository.save(accountant);
	}
}
