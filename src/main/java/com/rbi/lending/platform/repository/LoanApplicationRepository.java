package com.rbi.lending.platform.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbi.lending.platform.domain.entity.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, UUID> {

}
