package com.app.dto;

public class TransactionDTO {

  private Integer formAccountNo;
  
  private Integer toAccountNo;
  
  private Double amount;
  
  public TransactionDTO() {
	  
  }

public TransactionDTO(Integer formAccountNo, Integer toAccountNo, Double amount) {
	this.formAccountNo = formAccountNo;
	this.toAccountNo = toAccountNo;
	this.amount = amount;
}

public Integer getFormAccountNo() {
	return formAccountNo;
}

public void setFormAccountNo(Integer formAccountNo) {
	this.formAccountNo = formAccountNo;
}

public Integer getToAccountNo() {
	return toAccountNo;
}

public void setToAccountNo(Integer toAccountNo) {
	this.toAccountNo = toAccountNo;
}

public Double getAmount() {
	return amount;
}

public void setAmount(Double amount) {
	this.amount = amount;
}
  
  
  
}
