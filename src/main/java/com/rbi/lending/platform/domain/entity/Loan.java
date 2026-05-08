package com.rbi.lending.platform.domain.entity;

import java.math.BigDecimal;

import com.rbi.lending.platform.domain.enums.Purpose;

public class Loan {
	BigDecimal amount;
    Integer tenureMonths;
    Purpose purpose;
}
