package com.rbi.lending.platform.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class LoanApplicationRequest {
	@Valid
    @NotNull(message = "Applicant detail is mandatory")
    private ApplicantRequest applicant;

    @Valid
    @NotNull(message = "Loan detail is mandatory")
    private LoanRequest loan;
}
