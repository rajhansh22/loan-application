package com.rbi.lending.platform.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
	
	LocalDateTime timestamp;
    String message;
    List<String> errors;
    
	public ErrorResponse(LocalDateTime timestamp, String message, List<String> errors) {
		this.timestamp = timestamp;
		this.message = message;
		this.errors = errors;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
