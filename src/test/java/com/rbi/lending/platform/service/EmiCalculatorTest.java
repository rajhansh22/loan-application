package com.rbi.lending.platform.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmiCalculatorTest {
	
	private EmiCalculatorService emiCalculator;

    @BeforeEach
    void setUp() {
        emiCalculator = new EmiCalculatorService();
    }

    @Test
    @DisplayName("Should calculate EMI correctly")
    void shouldCalculateEmiCorrectly() {

        BigDecimal principal = BigDecimal.valueOf(500000);
        BigDecimal annualRate = BigDecimal.valueOf(12);
        int tenureMonths = 36;

        BigDecimal emi = emiCalculator.calculate(
                principal,
                annualRate,
                tenureMonths);

        assertThat(emi)
                .isNotNull();

        assertThat(emi.doubleValue())
                .isBetween(16600.0, 16700.0);
    }

    @Test
    @DisplayName("Should return positive EMI")
    void shouldReturnPositiveEmi() {

        BigDecimal emi = emiCalculator.calculate(
                BigDecimal.valueOf(100000),
                BigDecimal.valueOf(10),
                12);

        assertThat(emi)
                .isGreaterThan(BigDecimal.ZERO);
    }

    @Test
    @DisplayName("Higher tenure should reduce EMI")
    void higherTenureShouldReduceEmi() {

        BigDecimal shortTenureEmi =
                emiCalculator.calculate(
                        BigDecimal.valueOf(500000),
                        BigDecimal.valueOf(12),
                        12);

        BigDecimal longTenureEmi =
                emiCalculator.calculate(
                        BigDecimal.valueOf(500000),
                        BigDecimal.valueOf(12),
                        60);

        assertThat(longTenureEmi)
                .isLessThan(shortTenureEmi);
    }
}
