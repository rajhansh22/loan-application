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
}
