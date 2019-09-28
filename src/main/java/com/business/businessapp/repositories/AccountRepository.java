package com.business.businessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.businessapp.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
