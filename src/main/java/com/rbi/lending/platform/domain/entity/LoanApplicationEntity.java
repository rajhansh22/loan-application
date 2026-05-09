package com.rbi.lending.platform.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.rbi.lending.platform.domain.enums.*;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_applications")
public class LoanApplicationEntity {
	@Id
	UUID applicationId;
	
	@Embedded
    ApplicantEntity applicant;
	
	@Embedded
    LoanEntity loan;
	
	@Embedded
    LoanOfferEntity offer;
	
	@Enumerated(EnumType.STRING)
    Status status;
	
	@Enumerated(EnumType.STRING)
    RiskBand riskBand;
	
	@ElementCollection(targetClass = RejectionReason.class)
	@CollectionTable(
            name = "application_rejection_reasons",
            joinColumns = @JoinColumn(name = "application_id"))
	@Enumerated(EnumType.STRING)
    List<RejectionReason> rejectionReasons;
	
    LocalDateTime createdAt;
    
	public UUID getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(UUID applicationId) {
		this.applicationId = applicationId;
	}
	public ApplicantEntity getApplicant() {
		return applicant;
	}
	public void setApplicant(ApplicantEntity applicant) {
		this.applicant = applicant;
	}
	public LoanEntity getLoan() {
		return loan;
	}
	public void setLoan(LoanEntity loan) {
		this.loan = loan;
	}
	public LoanOfferEntity getOffer() {
		return offer;
	}
	public void setOffer(LoanOfferEntity offer) {
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
