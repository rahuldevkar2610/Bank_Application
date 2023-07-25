package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.TransactionStatus;

public interface transactionStatusRepository extends JpaRepository<TransactionStatus,String>{

}
