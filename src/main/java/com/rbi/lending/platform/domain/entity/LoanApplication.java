package com.rbi.lending.platform.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.rbi.lending.platform.domain.enums.*;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {
	@Id
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
