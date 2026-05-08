package com.rbi.lending.platform.dto;

import java.util.List;
import java.util.UUID;

import com.rbi.lending.platform.domain.enums.*;

public class LoanApplicationResponse {
	private UUID applicationId;

    private Status status;

    private RiskBand riskBand;

    private LoanOfferResponse offer;

    private List<RejectionReason> rejectionReasons;

	public LoanApplicationResponse(UUID applicationId, Status status, RiskBand riskBand, LoanOfferResponse offer,
			List<RejectionReason> reasons) {
		this.applicationId = applicationId;
		this.status = status;
		this.riskBand = riskBand;
		this.offer = offer;
		this.rejectionReasons = reasons;
	}

	public UUID getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(UUID applicationId) {
		this.applicationId = applicationId;
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

	public LoanOfferResponse getOffer() {
		return offer;
	}

	public void setOffer(LoanOfferResponse offer) {
		this.offer = offer;
	}

	public List<RejectionReason> getRejectionReasons() {
		return rejectionReasons;
	}

	public void setRejectionReasons(List<RejectionReason> rejectionReasons) {
		this.rejectionReasons = rejectionReasons;
	}
    
}
