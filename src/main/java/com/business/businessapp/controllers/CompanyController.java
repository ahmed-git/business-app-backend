package com.business.businessapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.businessapp.entities.Company;
import com.business.businessapp.repositories.CompanyRepository;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/all")
	public List<Company> getAll() {
		return companyRepository.findAll();
	}
}
