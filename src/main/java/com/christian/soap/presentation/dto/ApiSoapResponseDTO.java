package com.christian.soap.presentation.dto;

public record ApiSoapResponseDTO(
		OperationEnum operation,
		int result) {
}
