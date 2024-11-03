package com.christian.soap.presentation.dto;

public enum OperationEnum {
	ADD,
	SUBTRACT,
	MULTIPLY,
	DIVIDE;
	
	// METODO PARA OBTENER EL NOMBRE FORMATEADO PARA LA URL
	public String getUrlSegment() {
		return this.name().substring(0,1) + this.name().substring(1).toLowerCase();
	}
}
