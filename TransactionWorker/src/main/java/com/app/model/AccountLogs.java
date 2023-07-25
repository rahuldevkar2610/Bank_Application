package com.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="account_logs_tbl")
public class AccountLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "logs_id")
	private Integer logsId;
	
	@NotNull(message = "account id cannot be Null")
	@Column(name = "account_id")
	private Integer accountId;
	
	@NotNull(message = "amount cannot be Null")
	@Column(name = "amount")
	private Double amount;
	
	@NotNull(message = "operation cannot be Null")
	@Column(name = "operation")
	private String operation;
	
	@NotNull(message = "date and time cannot be Null")
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	public AccountLogs() {
		
	}

	public AccountLogs( Integer accountId, Double amount, String operation, LocalDateTime createdAt) {
		this.accountId = accountId;
		this.amount = amount;
		this.operation = operation;
		this.createdAt = createdAt;
	}

	public Integer getLogsId() {
		return logsId;
	}

	public void setLogsId(Integer logsId) {
		this.logsId = logsId;
	}

	public Integer getAccount() {
		return accountId;
	}

	public void setAccount(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "AccountLogs [logsId=" + logsId + ", accountId=" + accountId + ", amount=" + amount + ", operation="
				+ operation + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
}
