package com.business.businessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.businessapp.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
