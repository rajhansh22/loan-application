package com.rbi.lending.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rbi.lending.platform.dto.LoanApplicationRequest;
import com.rbi.lending.platform.dto.LoanApplicationResponse;
import com.rbi.lending.platform.service.LoanApplicationService;

import jakarta.validation.Valid;

@RestController
public class LoanApplicationController {
	
	@Autowired
	private LoanApplicationService service;

    @PostMapping("/applications")
    public ResponseEntity<LoanApplicationResponse>
    create(@Valid @RequestBody LoanApplicationRequest request) {

        return ResponseEntity.ok(
                service.process(request));
    }
}
