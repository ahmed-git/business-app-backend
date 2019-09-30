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

import com.business.businessapp.entities.Company;
import com.business.businessapp.entities.Manager;
import com.business.businessapp.repositories.ManagerRepository;

@RestController
@RequestMapping("/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {

	@Autowired 
	private ManagerRepository managerRepository;
	
	@GetMapping("/all")
	public List<Manager> getAll() {
		return managerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Manager get(@PathVariable Long id) {
		return managerRepository.findById(id).get();
	}
	
	@PostMapping("/update")
	public void save(@RequestBody Manager manager) {
		Company company = new Company();
		company.setId(manager.getCompany().getId());
		manager.setCompany(company);
		manager.setLastModified(LocalDate.now());
		managerRepository.save(manager);
	}
	
}
