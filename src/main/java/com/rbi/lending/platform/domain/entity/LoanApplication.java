package com.rbi.lending.platform.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.rbi.lending.platform.domain.enums.*;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {
	@Id
    @GeneratedValue
	UUID applicationId;
	
	@Embedded
    Applicant applicant;
	
	@Embedded
    Loan loan;
	
	@Embedded
    LoanOffer offer;
	
	@Enumerated(EnumType.STRING)
    Status status;
	
	@Enumerated(EnumType.STRING)
    RiskBand riskBand;
	
	@ElementCollection(targetClass = RejectionReason.class)
	@Enumerated(EnumType.STRING)
    List<RejectionReason> rejectionReasons;
	
    LocalDateTime createdAt;
    
	public UUID getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(UUID applicationId) {
		this.applicationId = applicationId;
	}
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	public Loan getLoan() {
		return loan;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	public LoanOffer getOffer() {
		return offer;
	}
	public void setOffer(LoanOffer offer) {
		this.offer = offer;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public RiskBand getRiskBand() {
		return riskBand;
	}
	public void setRiskBand(RiskBand riskBand) {
		this.riskBand = riskBand;
	}
	public List<RejectionReason> getRejectionReasons() {
		return rejectionReasons;
	}
	public void setRejectionReasons(List<RejectionReason> rejectionReasons) {
		this.rejectionReasons = rejectionReasons;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
