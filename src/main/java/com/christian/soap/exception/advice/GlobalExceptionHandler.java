package com.christian.soap.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Si solo necesitas validar que los parametros sean numeros, sin importar si son positivos o negativos, 
	 * y usas int o Integer como tipo en los parametros del metodo, 
	 * Spring lanzara una excepcion MethodArgumentTypeMismatchException si el valor proporcionado no es un numero.
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		ErrorResponse response = new ErrorResponse("Invalid input: parameters must be integers",ex.getMessage());		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
