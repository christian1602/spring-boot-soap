package com.christian.soap.service;

import com.christian.soap.presentation.dto.ApiSoapResponseDTO;

public interface ISoapClientService {

	ApiSoapResponseDTO getAddResponse(int numberA, int numberB);
	ApiSoapResponseDTO getSubtractResponse(int numberA, int numberB);
	ApiSoapResponseDTO getMultiplyResponse(int numberA, int numberB);
	ApiSoapResponseDTO getDivideResponse(int numberA, int numberB);
}
