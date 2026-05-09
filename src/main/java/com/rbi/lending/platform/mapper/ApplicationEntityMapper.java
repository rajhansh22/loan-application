package com.rbi.lending.platform.mapper;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.rbi.lending.platform.domain.entity.ApplicantEntity;
import com.rbi.lending.platform.domain.entity.LoanEntity;
import com.rbi.lending.platform.domain.entity.LoanApplicationEntity;
import com.rbi.lending.platform.domain.entity.LoanOfferEntity;
import com.rbi.lending.platform.dto.ApplicantRequest;
import com.rbi.lending.platform.dto.LoanApplicationRequest;
import com.rbi.lending.platform.dto.LoanApplicationResponse;
import com.rbi.lending.platform.dto.LoanOfferResponse;
import com.rbi.lending.platform.dto.LoanRequest;

@Component
public class ApplicationEntityMapper {
	public LoanApplicationEntity toEntity(
            LoanApplicationRequest request, LoanApplicationResponse response) {

        LoanApplicationEntity entity =
                new LoanApplicationEntity();
        
        entity.setApplicationId(response.getApplicationId());

        entity.setApplicant(
                mapApplicant(request.getApplicant()));

        entity.setLoan(
                mapLoan(request.getLoan()));

        entity.setStatus(response.getStatus());
        
        entity.setRiskBand(response.getRiskBand());
        
        entity.setOffer(mapLoanOffer(response.getOffer()));
        
        entity.setRejectionReasons(response.getRejectionReasons());

        entity.setCreatedAt(LocalDateTime.now());

        return entity;
    }

    private ApplicantEntity mapApplicant(
            ApplicantRequest request) {

        ApplicantEntity applicant = new ApplicantEntity();

        applicant.setName(request.getName());
        applicant.setAge(request.getAge());
        applicant.setMonthlyIncome(
                request.getMonthlyIncome());

        applicant.setEmploymentType(
                request.getEmploymentType());

        applicant.setCreditScore(
                request.getCreditScore());

        return applicant;
    }

    private LoanEntity mapLoan(
            LoanRequest request) {

        LoanEntity loan = new LoanEntity();

        loan.setAmount(request.getAmount());

        loan.setTenureMonths(
                request.getTenureMonths());

        loan.setPurpose(request.getPurpose());

        return loan;
    }
    
    private LoanOfferEntity mapLoanOffer(
    		LoanOfferResponse response) {
    	
    	if(Optional.ofNullable(response).isEmpty())return null;

    	LoanOfferEntity offer = new LoanOfferEntity();

        offer.setEmi(response.getEmi());
        
        offer.setInterestRate(response.getInterestRate());
        
        offer.setTenureMonths(response.getTenureMonths());
        
        offer.setTotalPayable(response.getTotalPayable());

        return offer;
    }
}
