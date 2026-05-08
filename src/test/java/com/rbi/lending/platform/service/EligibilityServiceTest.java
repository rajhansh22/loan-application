package com.rbi.lending.platform.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.rbi.lending.platform.domain.enums.RejectionReason;

public class EligibilityServiceTest {
	
	private EligibilityService service;

    @BeforeEach
    void setUp() {
        service = new EligibilityService();
    }

    @Test
    @DisplayName("Should approve eligible applicant")
    void shouldApproveEligibleApplicant() {

        List<RejectionReason> reasons =
                service.validate(
                        750,
                        30,
                        36,
                        BigDecimal.valueOf(15000),
                        BigDecimal.valueOf(50000));

        assertThat(reasons)
                .isEmpty();
    }

    @Test
    @DisplayName("Should reject low credit score")
    void shouldRejectLowCreditScore() {

        List<RejectionReason> reasons =
                service.validate(
                        550,
                        30,
                        36,
                        BigDecimal.valueOf(15000),
                        BigDecimal.valueOf(50000));

        assertThat(reasons)
                .contains(
                        RejectionReason.LOW_CREDIT_SCORE);
    }

    @Test
    @DisplayName("Should reject when age tenure limit exceeded")
    void shouldRejectAgeTenureLimitExceeded() {

        List<RejectionReason> reasons =
                service.validate(
                        750,
                        60,
                        120,
                        BigDecimal.valueOf(15000),
                        BigDecimal.valueOf(50000));

        assertThat(reasons)
                .contains(
                        RejectionReason
                                .AGE_TENURE_LIMIT_EXCEEDED);
    }

    @Test
    @DisplayName("Should reject EMI exceeding 50 percent")
    void shouldRejectEmiExceeding50Percent() {

        List<RejectionReason> reasons =
                service.validate(
                        750,
                        30,
                        36,
                        BigDecimal.valueOf(3000),
                        BigDecimal.valueOf(50000));

        assertThat(reasons)
                .contains(
                        RejectionReason
                                .EMI_EXCEEDS_50_PERCENT);
    }

//    @Test
//    @DisplayName("Should reject EMI exceeding 60 percent")
//    void shouldRejectEmiExceeding60Percent() {
//
//        List<RejectionReason> reasons =
//                service.validate(
//                        750,
//                        30,
//                        36,
//                        BigDecimal.valueOf(35000),
//                        BigDecimal.valueOf(50000));
//
//        assertThat(reasons)
//                .contains(
//                        RejectionReason
//                                .EMI_EXCEEDS_60_PERCENT);
//    }

    @Test
    @DisplayName("Should return multiple rejection reasons")
    void shouldReturnMultipleRejectionReasons() {

        List<RejectionReason> reasons =
                service.validate(
                        550,
                        60,
                        120,
                        BigDecimal.valueOf(40000),
                        BigDecimal.valueOf(50000));

        assertThat(reasons)
                .hasSizeGreaterThanOrEqualTo(3);

        assertThat(reasons)
                .contains(
                        RejectionReason.LOW_CREDIT_SCORE,
                        RejectionReason
                                .AGE_TENURE_LIMIT_EXCEEDED,
                        RejectionReason
                                .EMI_EXCEEDS_50_PERCENT
                );
    }
}
