package com.rbi.lending.platform.domain.entity;

import java.math.BigDecimal;

import com.rbi.lending.platform.domain.enums.Purpose;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Loan {
	BigDecimal amount;
	
    Integer tenureMonths;
    
    @Enumerated(EnumType.STRING)
    Purpose purpose;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getTenureMonths() {
		return tenureMonths;
	}

	public void setTenureMonths(Integer tenureMonths) {
		this.tenureMonths = tenureMonths;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}
}
