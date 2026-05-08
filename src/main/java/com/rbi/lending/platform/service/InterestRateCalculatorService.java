package com.rbi.lending.platform.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.rbi.lending.platform.domain.enums.*;

@Service
public class InterestRateCalculatorService {
	
	private static final BigDecimal BASE_RATE =
            BigDecimal.valueOf(12);

    public BigDecimal calculate(
            RiskBand riskBand,
            EmploymentType employmentType,
            BigDecimal loanAmount) {

        BigDecimal rate = BASE_RATE;

        if(RiskBand.MEDIUM.equals(riskBand)) {
        	rate = rate.add(BigDecimal.valueOf(1.5));
        } else if(RiskBand.MEDIUM.equals(riskBand)) {
        	rate = rate.add(BigDecimal.valueOf(3));
        }

        if (EmploymentType.SELF_EMPLOYED.equals(employmentType)) {
            rate = rate.add(BigDecimal.ONE);
        }

        if (loanAmount.compareTo(BigDecimal.valueOf(1000000)) > 0) {
            rate = rate.add(BigDecimal.valueOf(0.5));
        }

        return rate;
    }
}
