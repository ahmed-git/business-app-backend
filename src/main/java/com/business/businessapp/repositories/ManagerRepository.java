package com.business.businessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.businessapp.entities.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
