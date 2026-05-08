package com.rbi.lending.platform.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rbi.lending.platform.domain.enums.RejectionReason;

@Service
public class EligibilityService {
	
	public List<RejectionReason> validate(
            int creditScore,
            int age,
            int tenureMonths,
            BigDecimal emi,
            BigDecimal income) {

        List<RejectionReason> reasons = new ArrayList<>();

        if (creditScore < 600) {
            reasons.add(RejectionReason.LOW_CREDIT_SCORE);
        }

        int tenureYears = tenureMonths / 12;

        if (age + tenureYears > 65) {
            reasons.add(
                    RejectionReason.AGE_TENURE_LIMIT_EXCEEDED);
        }
        
        BigDecimal fiftyPercentMonthlyIncome =
                income.multiply(BigDecimal.valueOf(0.5));

        if (emi.compareTo(fiftyPercentMonthlyIncome) > 0) {
            reasons.add(
                    RejectionReason.EMI_EXCEEDS_50_PERCENT);
        }

        return reasons;
    }
}
