package com.rbi.lending.platform.domain.entity;

import java.math.BigDecimal;

import com.rbi.lending.platform.domain.enums.EmploymentType;

public class Applicant {
	String name;
    Integer age;
    BigDecimal monthlyIncome;
    EmploymentType employmentType;
    Integer creditScore;
}
