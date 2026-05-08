package com.rbi.lending.platform.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbi.lending.platform.domain.enums.RejectionReason;
import com.rbi.lending.platform.domain.enums.RiskBand;
import com.rbi.lending.platform.domain.enums.Status;
import com.rbi.lending.platform.dto.LoanApplicationRequest;
import com.rbi.lending.platform.dto.LoanApplicationResponse;
import com.rbi.lending.platform.dto.LoanOfferResponse;

@Service
public class LoanApplicationService {
	@Autowired
	private RiskAssessmentService riskAssessmentService;
	@Autowired
    private InterestRateCalculatorService interestRateCalculatorService;
	@Autowired
    private EmiCalculatorService emiCalculatorService;
	@Autowired
    private EligibilityService eligibilityService;

    public LoanApplicationResponse process(
            LoanApplicationRequest request) {

        UUID applicationId = UUID.randomUUID();

        RiskBand riskBand =
                riskAssessmentService.getRiskBand(
                        request.getApplicant().getCreditScore());

        BigDecimal interestRate =
                interestRateCalculatorService.calculate(
                        riskBand,
                        request.getApplicant().getEmploymentType(),
                        request.getLoan().getAmount());

        BigDecimal emi =
                emiCalculatorService.calculate(
                        request.getLoan().getAmount(),
                        interestRate,
                        request.getLoan().getTenureMonths());

        List<RejectionReason> reasons =
                eligibilityService.validate(
                        request.getApplicant().getCreditScore(),
                        request.getApplicant().getAge(),
                        request.getLoan().getTenureMonths(),
                        emi,
                        request.getApplicant().getMonthlyIncome());

        if (!reasons.isEmpty()) {

            return new LoanApplicationResponse(
                    applicationId,
                    Status.REJECTED,
                    null,
                    null,
                    reasons
            );
        }

        BigDecimal totalPayable =
                emi.multiply(
                        BigDecimal.valueOf(
                                request.getLoan().getTenureMonths()));

        LoanOfferResponse offer =
                new LoanOfferResponse(
                        interestRate,
                        request.getLoan().getTenureMonths(),
                        emi,
                        totalPayable);

        return new LoanApplicationResponse(
                applicationId,
                Status.APPROVED,
                riskBand,
                offer,
                null
        );
    }
}
