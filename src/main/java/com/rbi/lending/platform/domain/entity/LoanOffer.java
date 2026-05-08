package com.rbi.lending.platform.domain.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LoanOffer {
	
	BigDecimal interestRate;
	
	@Column(name = "tenureMonths", insertable = false, updatable = false)
    Integer tenureMonths;
	
    BigDecimal emi;
    
    BigDecimal totalPayable;
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	public Integer getTenureMonths() {
		return tenureMonths;
	}
	public void setTenureMonths(Integer tenureMonths) {
		this.tenureMonths = tenureMonths;
	}
	public BigDecimal getEmi() {
		return emi;
	}
	public void setEmi(BigDecimal emi) {
		this.emi = emi;
	}
	public BigDecimal getTotalPayable() {
		return totalPayable;
	}
	public void setTotalPayable(BigDecimal totalPayable) {
		this.totalPayable = totalPayable;
	}
    
}
