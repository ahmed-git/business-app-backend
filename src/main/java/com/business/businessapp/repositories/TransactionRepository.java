package com.business.businessapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business.businessapp.entities.Transaction;
import com.business.businessapp.entities.TransactionAccountResponse;
import com.business.businessapp.entities.TransactionStatus;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("SELECT new com.business.businessapp.entities.TransactionAccountResponse(t.transactionDate as date, (case when t.receiver.id=:id then t.amount "
			+ "when t.sender.id=:id then -t.amount end) as amount, "
			+ "(case when t.receiver.id=:id then sender.company.name when t.sender.id=:id then receiver.company.name end) as company) "
			+ "FROM Transaction t WHERE t.sender.id = :id or t.receiver.id = :id")
	public List<TransactionAccountResponse> findAllByAccountId(@Param("id") Long id);
	
	
	public List<Transaction> findAllByStatus(@Param("status") TransactionStatus status);
	
}
