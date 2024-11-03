package com.christian.soap.exception.advice;

public record ErrorResponse(
		String message, 
		Object error) {
}
