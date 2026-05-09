package com.rbi.lending.platform.mapper;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.rbi.lending.platform.domain.entity.Applicant;
import com.rbi.lending.platform.domain.entity.Loan;
import com.rbi.lending.platform.domain.entity.LoanApplication;
import com.rbi.lending.platform.domain.entity.LoanOffer;
import com.rbi.lending.platform.dto.ApplicantRequest;
import com.rbi.lending.platform.dto.LoanApplicationRequest;
import com.rbi.lending.platform.dto.LoanApplicationResponse;
import com.rbi.lending.platform.dto.LoanOfferResponse;
import com.rbi.lending.platform.dto.LoanRequest;

@Component
public class ApplicationEntityMapper {
	public LoanApplication toEntity(
            LoanApplicationRequest request, LoanApplicationResponse response) {

        LoanApplication entity =
                new LoanApplication();
        
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

    private Applicant mapApplicant(
            ApplicantRequest request) {

        Applicant applicant = new Applicant();

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

    private Loan mapLoan(
            LoanRequest request) {

        Loan loan = new Loan();

        loan.setAmount(request.getAmount());

        loan.setTenureMonths(
                request.getTenureMonths());

        loan.setPurpose(request.getPurpose());

        return loan;
    }
    
    private LoanOffer mapLoanOffer(
    		LoanOfferResponse response) {
    	
    	if(Optional.ofNullable(response).isEmpty())return null;

    	LoanOffer offer = new LoanOffer();

        offer.setEmi(response.getEmi());
        
        offer.setInterestRate(response.getInterestRate());
        
        offer.setTenureMonths(response.getTenureMonths());
        
        offer.setTotalPayable(response.getTotalPayable());

        return offer;
    }
}
