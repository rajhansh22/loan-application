package com.rbi.lending.platform.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.rbi.lending.platform.domain.enums.*;

public class LoanApplication {
	UUID applicationId;
    Applicant applicant;
    Loan loan;
    LoanOffer offer;
    Status status;
    RiskBand riskBand;
    List<String> rejectionReasons;
    LocalDateTime createdAt;
}
