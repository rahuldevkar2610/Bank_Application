package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.app.dto.TransactionDTO;
import com.app.model.Account;
import com.app.model.AccountNumberGenerator;
import com.app.repository.accountRepository;
import com.app.utils.KafkaConstants;



@Service
public class accountService {

	@Autowired
	private accountRepository accountRepo;
	
	@Autowired
	private KafkaTemplate<String, TransactionDTO> kafkaTemplate;
	
	public Integer newAccount(Account account) {
		account.setAccountId(AccountNumberGenerator.generateAccountNumber());
	 return	accountRepo.save(account).getAccountId();
	}

	public Account getAccount(Integer accountNumber) {
		return accountRepo.findById(accountNumber).get();
		
	}
	
	public String transaction(TransactionDTO transactionDto) {
		 kafkaTemplate.send(KafkaConstants.TOPIC,transactionDto);
		 return "transaction made successfully";
	}
}
