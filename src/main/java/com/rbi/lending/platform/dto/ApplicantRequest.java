package com.rbi.lending.platform.dto;

import java.math.BigDecimal;

import com.rbi.lending.platform.domain.enums.EmploymentType;

import jakarta.validation.constraints.*;

public class ApplicantRequest {
	@NotBlank(message = "Name must be provided")
    private String name;

    @NotNull
    @Min(value = 21, message = "Age must be at least 21")
    @Max(value = 60, message = "Age must not exceed 60")
    private Integer age;

    @NotNull
    @DecimalMin(value = "0.1",
            message = "Monthly income must be greater than 0")
    private BigDecimal monthlyIncome;

    @NotNull
    private EmploymentType employmentType;

    @NotNull
    @Min(value = 300, message = "Credit score must be >= 300")
    @Max(value = 900, message = "Credit score must be <= 900")
    private Integer creditScore;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(BigDecimal monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	public Integer getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}
}
