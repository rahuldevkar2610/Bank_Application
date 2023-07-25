package com.app.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.concurrent.atomic.AtomicInteger;
@Entity
@Table(name="account_tbl")
public class Account {

	@Id
	@Column(name = "account_id")
	private Integer accountId;
	
	@NotNull(message = "owner name cannot be Null")
	@Column(name = "owner_name", length = 20)
	private String owner;
	
	@NotNull(message = "account type cannot be Null")
	@Column(name = "account_type", length = 20)
	private String accountType;
	
	@NotNull(message = "balance  cannot be Null")
	@Column(name = "balance")
	private Double balance;
	
	public Account() {
		
	}

	public Account( String owner, String accountType, Double balance) {
		this.owner = owner;
		this.accountType = accountType;
		this.balance = balance;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", owner=" + owner + ", accountType=" + accountType + ", balance="
				+ balance + "]";
	}
}
