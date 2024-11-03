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

	// COMO EL BEAN SoapClientServiceImpl YA EXISTE (FUE CREADO EN SoapConfig) ENTONCES SOLO LO INYECTAMOS
	// SI QUEREMOS USAR OTRO NOMBRE, EL IDE NOS DARA EL SIGUIENTE MENSAJE:
	// Considere marcar uno de los beans como @Primary, actualizar el consumidor para que acepte múltiples beans, o 
	// utilizar @Qualifier para identificar el bean que debe ser consumido
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
