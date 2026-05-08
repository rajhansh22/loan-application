package com.rbi.lending.platform.dto;

import java.math.BigDecimal;

import com.rbi.lending.platform.domain.enums.Purpose;
import jakarta.validation.constraints.*;

public class LoanRequest {
	@NotNull
    @DecimalMin(value = "10000",
            message = "Loan amount must be at least 10000")
    @DecimalMax(value = "5000000",
            message = "Loan amount must not exceed 5000000")
    private BigDecimal amount;

    @NotNull
    @Min(value = 6, message = "Tenure must be at least 6 months")
    @Max(value = 360, message = "Tenure must not exceed 360 months")
    private Integer tenureMonths;

    @NotNull
    private Purpose purpose;

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
