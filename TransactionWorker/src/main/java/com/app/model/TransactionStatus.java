package com.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="transaction_status_table")
public class TransactionStatus {

	@Id
	@Column(name = "transaction_id")
	private String transactionId;
	
	@NotNull(message = "account cannot be Null")
	@Column(name = "form_account_id")
	private Integer formAccountId;
	
	@NotNull(message = "account cannot be Null")
	@Column(name = "to_account_id")
	private Integer toAccountId;
	
	@NotNull(message = "amount cannot be Null")
	@Column(name = "amount")
	private Double amount;
	
	@NotNull(message = "date and time cannot be Null")
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	public TransactionStatus() {
		
	}

	public TransactionStatus(String transactionId, Integer formAccountId, Integer toAccountId, Double amount,
			LocalDateTime createdAt) {
		this.transactionId = transactionId;
		this.formAccountId = formAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.createdAt = createdAt;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getFormAccountId() {
		return formAccountId;
	}

	public void setFormAccountId(Integer formAccountId) {
		this.formAccountId = formAccountId;
	}

	public Integer getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "TransactionStatus [transactionId=" + transactionId + ", formAccountId=" + formAccountId
				+ ", toAccountId=" + toAccountId + ", amount=" + amount + ", createdAt=" + createdAt + "]";
	}
	
	
	
}
