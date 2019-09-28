package com.business.businessapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
