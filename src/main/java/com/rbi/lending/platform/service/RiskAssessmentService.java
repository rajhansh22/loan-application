package com.rbi.lending.platform.service;

import org.springframework.stereotype.Service;

import com.rbi.lending.platform.domain.enums.RiskBand;

@Service
public class RiskAssessmentService {
	
	public RiskBand getRiskBand(int creditScore) {

        if (creditScore >= 750) {
            return RiskBand.LOW;
        }

        if (creditScore >= 650) {
            return RiskBand.MEDIUM;
        }

        return RiskBand.HIGH;
    }

}
