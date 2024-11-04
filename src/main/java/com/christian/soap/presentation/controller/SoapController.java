package com.christian.soap.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.christian.soap.presentation.dto.ApiSoapResponseDTO;
import com.christian.soap.service.ISoapClientService;

@RestController
@RequestMapping("/soap")
public class SoapController {

	// EN ESTE PUNTO TENEMOS 2 IMPLEMENTACIONES DE ISoapClientService
	// 1. EL BEAN soapClient CREADO EN SoapConfig
	// 2. EL BEAN SoapClientServiceImpl CREADO COMO UN @Service
	// DEBIDO A QUE soapClient CREADO EN SoapConfig TIENE LA ANOTACION @Primary SERA ELEGIDO
	private final ISoapClientService soapClientService;

	public SoapController(ISoapClientService soapClientService) {
		this.soapClientService = soapClientService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestParam int numberA, @RequestParam int numberB) {
		ApiSoapResponseDTO apiSoapResponseDTO = this.soapClientService.getAddResponse(numberA, numberB);
		return new ResponseEntity<>(apiSoapResponseDTO, HttpStatus.OK);
	}

	@PostMapping("/subtract")
	public ResponseEntity<?> subtract(@RequestParam int numberA, @RequestParam int numberB) {
		ApiSoapResponseDTO apiSoapResponseDTO = this.soapClientService.getSubtractResponse(numberA, numberB);
		return new ResponseEntity<>(apiSoapResponseDTO, HttpStatus.OK);
	}

	@PostMapping("/multiply")
	public ResponseEntity<?> multiply(@RequestParam int numberA, @RequestParam int numberB) {
		ApiSoapResponseDTO apiSoapResponseDTO = this.soapClientService.getMultiplyResponse(numberA, numberB);
		return new ResponseEntity<>(apiSoapResponseDTO, HttpStatus.OK);
	}

	@PostMapping("/divide")
	public ResponseEntity<?> divide(@RequestParam int numberA, @RequestParam int numberB) {
		ApiSoapResponseDTO apiSoapResponseDTO = this.soapClientService.getDivideResponse(numberA, numberB);
		return new ResponseEntity<>(apiSoapResponseDTO, HttpStatus.OK);
	}
}
