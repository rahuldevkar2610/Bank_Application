package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Account;

@Repository
public interface accountRepository extends JpaRepository<Account,Integer> {

}
