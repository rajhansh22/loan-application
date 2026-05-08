package com.rbi.lending.platform.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.rbi.lending.platform.domain.enums.RiskBand;

public class RiskAssessmentServiceTest {
	
	private RiskAssessmentService service;

    @BeforeEach
    void setUp() {
        service = new RiskAssessmentService();
    }

    @Test
    @DisplayName("Should classify LOW risk")
    void shouldClassifyLowRisk() {

        RiskBand riskBand = service.getRiskBand(780);

        assertThat(riskBand)
                .isEqualTo(RiskBand.LOW);
    }

    @Test
    @DisplayName("Should classify MEDIUM risk")
    void shouldClassifyMediumRisk() {

        RiskBand riskBand = service.getRiskBand(700);

        assertThat(riskBand)
                .isEqualTo(RiskBand.MEDIUM);
    }

    @Test
    @DisplayName("Should classify HIGH risk")
    void shouldClassifyHighRisk() {

        RiskBand riskBand = service.getRiskBand(620);

        assertThat(riskBand)
                .isEqualTo(RiskBand.HIGH);
    }

    @Test
    @DisplayName("Boundary test for LOW risk")
    void shouldClassify750AsLowRisk() {

        RiskBand riskBand = service.getRiskBand(750);

        assertThat(riskBand)
                .isEqualTo(RiskBand.LOW);
    }

    @Test
    @DisplayName("Boundary test for MEDIUM risk")
    void shouldClassify650AsMediumRisk() {

        RiskBand riskBand = service.getRiskBand(650);

        assertThat(riskBand)
                .isEqualTo(RiskBand.MEDIUM);
    }
}
