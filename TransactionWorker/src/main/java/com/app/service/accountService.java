package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.app.dto.TransactionDTO;
import com.app.model.Account;
import com.app.model.AccountLogs;
import com.app.model.TransactionIdGenerator;
import com.app.model.TransactionStatus;
import com.app.repository.accountLogsRepository;
import com.app.repository.accountRepository;
import com.app.repository.transactionStatusRepository;
import com.app.utils.KafkaConstants;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class accountService {

	@Autowired
	private accountRepository accountRepo;
	
	@Autowired
	private accountLogsRepository accountLogsRepo;
	
	@Autowired
	private transactionStatusRepository transactionStatusRepo;
	
	@KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
	public TransactionDTO listener(TransactionDTO transactionDto) {
		List<AccountLogs> accountLogs=new ArrayList<>();
      Account formAccount=accountRepo.findById(transactionDto.getFormAccountNo()).get();
     Account toAccount= accountRepo.findById(transactionDto.getToAccountNo()).get();
       if(formAccount.getBalance()>transactionDto.getAmount()) {
    	   formAccount.setBalance(formAccount.getBalance()-transactionDto.getAmount());
    	   toAccount.setBalance(toAccount.getBalance()+transactionDto.getAmount());
    	   accountRepo.save(formAccount);
    	   accountRepo.save(toAccount);
       }
       
       accountLogs.add(new AccountLogs(formAccount.getAccountId(),transactionDto.getAmount(),"Debited",LocalDateTime.now()));
       accountLogs.add(new AccountLogs(toAccount.getAccountId(),transactionDto.getAmount(),"Credited",LocalDateTime.now()));
       for (AccountLogs logs : accountLogs) {
		accountLogsRepo.save(logs);
	}
       TransactionStatus transactionStatus=new TransactionStatus();
       transactionStatus.setTransactionId(TransactionIdGenerator.generateTransactionId());
       transactionStatus.setFormAccountId(formAccount.getAccountId());
       transactionStatus.setToAccountId(toAccount.getAccountId());
       transactionStatus.setAmount(transactionDto.getAmount());
       transactionStatus.setCreatedAt(LocalDateTime.now());
       transactionStatusRepo.save(transactionStatus);
		return transactionDto;
	}
	
	
}
