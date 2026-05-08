package com.rbi.lending.platform.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

@Service
public class EmiCalculatorService {
	
	private static final int SCALE = 2;
	
	public BigDecimal calculate(
            BigDecimal principal,
            BigDecimal annualRate,
            int tenureMonths) {

        BigDecimal monthlyRate =
                annualRate.divide(
                        BigDecimal.valueOf(12 * 100),
                        10,
                        RoundingMode.HALF_UP);

        double r = monthlyRate.doubleValue();

        double numerator =
                principal.doubleValue()
                        * r
                        * Math.pow(1 + r, tenureMonths);

        double denominator =
                Math.pow(1 + r, tenureMonths) - 1;

        return BigDecimal.valueOf(numerator / denominator)
                .setScale(SCALE, RoundingMode.HALF_UP);
    }

}
