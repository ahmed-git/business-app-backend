package com.business.businessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.businessapp.entities.Accountant;

@Repository
public interface AccountantRepository extends JpaRepository<Accountant, Long> {

}
