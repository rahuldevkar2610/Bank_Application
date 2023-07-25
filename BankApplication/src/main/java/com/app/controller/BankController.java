package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TransactionDTO;
import com.app.model.Account;
import com.app.service.accountService;

@RestController
public class BankController {
	
	@Autowired
	private accountService accountServ;

	@PostMapping("/create_account")
	public Integer createAccount(@RequestBody Account account) {
	 return accountServ.newAccount(account);
	}	
	
	@GetMapping("/get_account_details")
	public Account getAccountInfo(@RequestParam Integer accountNumber) {
		return accountServ.getAccount(accountNumber);
	}
	@PostMapping("/create_transaction")
	public String createTransactions(@RequestBody TransactionDTO transactionDTO) {
		return accountServ.transaction(transactionDTO);
	}
}
