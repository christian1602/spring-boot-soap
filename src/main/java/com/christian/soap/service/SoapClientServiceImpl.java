package com.christian.soap.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.christian.soap.presentation.dto.ApiSoapResponseDTO;
import com.christian.soap.presentation.dto.OperationEnum;
import com.christian.soap.wsdl.Add;
import com.christian.soap.wsdl.AddResponse;
import com.christian.soap.wsdl.Divide;
import com.christian.soap.wsdl.DivideResponse;
import com.christian.soap.wsdl.Multiply;
import com.christian.soap.wsdl.MultiplyResponse;
import com.christian.soap.wsdl.Subtract;
import com.christian.soap.wsdl.SubtractResponse;

@Service
public class SoapClientServiceImpl extends WebServiceGatewaySupport implements ISoapClientService {

	@Value("${soap.client.default-uri}")
	private String defaultUri;
	
	@Value("${soap.client.action-callback}")
	private String soapActionCallback;

	/**
	 * Metodo que se encarga de sumar dos numeros
	 * @param numberA
	 * @param numberB
	 * @return ApiSoapResponseDTO
	 */
	@Override
	public ApiSoapResponseDTO getAddResponse(int numberA, int numberB) {
		
		// DEFINIMOS NUESTRO OBJETO REQUEST
		Add addRequest = new Add();
		addRequest.setIntA(numberA);
		addRequest.setIntB(numberB);
		
		// this.defaultUri ES LA URL DEL SERVICIO SOAP (SIN EL ?WSDL)
		
		// EL ARGUMENTO DE SoapActionCallback PROVIENE DEL WSDL
		// <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org/">
		// SINO ESTUVIERA SE DEBE CONSULTAR AL PROVEEDOR DEL WSDL
		// SEGUIDO LE AGREGAMOS EL NOMBRE DEL METODO
		// <s:element name="Add">
		SoapActionCallback soapActionCallback = new SoapActionCallback(this.soapActionCallback.concat(OperationEnum.ADD.getUrlSegment()));
		
		// URL DEL API SOAP SIN EL ?WSDL
		// <url>http://www.dneonline.com/calculator.asmx?WSDL</url>
		// SE ENCUENTRA EN EL pom.xml
		// OTRAS VECES SE ENCUENTRA EL MISMO WSDL, BUSCANDO POR LA PALABRA location
		// <soap:address location="http://www.dneonline.com/calculator.asmx"/>
		// <soap12:address location="http://www.dneonline.com/calculator.asmx"/>
		
		AddResponse addResponse = (AddResponse) this.getWebServiceTemplate().marshalSendAndReceive(this.defaultUri, addRequest, soapActionCallback);
		
		// Explicacion de los cambios
		// 1. Cambio de sendAndReceive a marshalSendAndReceive: 
		// marshalSendAndReceive convierte automaticamente (marshal) el objeto Add en XML, 
		// lo envia al servicio SOAP y convierte (unmarshal) la respuesta XML en un objeto Java de tipo AddResponse.
		// 2. Casting a AddResponse: 
		// marshalSendAndReceive retorna un objeto de tipo Object, por lo que necesitas hacer un cast explicito a AddResponse para asignarlo a la variable addResponse.
		// RECORDA QUE SoapActionCallback es una subclase de WebServiceMessageCallback
		
		return new ApiSoapResponseDTO(OperationEnum.ADD, addResponse.getAddResult());
	}
	
	/**
	 * Metodo que se encarga de restar dos numeros
	 * @param numberA
	 * @param numberB
	 * @return ApiSoapResponseDTO
	 */
	@Override
	public ApiSoapResponseDTO getSubtractResponse(int numberA, int numberB) {
		Subtract subtractRequest = new Subtract();
		subtractRequest.setIntA(numberA);
		subtractRequest.setIntB(numberB);
				
		SoapActionCallback soapActionCallback = new SoapActionCallback(this.soapActionCallback.concat(OperationEnum.SUBTRACT.getUrlSegment()));		
		SubtractResponse subtractResponse = (SubtractResponse) this.getWebServiceTemplate().marshalSendAndReceive(this.defaultUri, subtractRequest, soapActionCallback);
				  
		return new ApiSoapResponseDTO(OperationEnum.SUBTRACT, subtractResponse.getSubtractResult());
	}
	
	/**
	 * Metodo que se encarga de multiplicar dos numeros
	 * @param numberA
	 * @param numberB
	 * @return ApiSoapResponseDTO
	 */
	@Override
	public ApiSoapResponseDTO getMultiplyResponse(int numberA, int numberB) {
		Multiply multiplyRequest = new Multiply();
		multiplyRequest.setIntA(numberA);
		multiplyRequest.setIntB(numberB);
				
		SoapActionCallback soapActionCallback = new SoapActionCallback(this.soapActionCallback.concat(OperationEnum.MULTIPLY.getUrlSegment()));		
		MultiplyResponse multiplyResponse = (MultiplyResponse) this.getWebServiceTemplate().marshalSendAndReceive(this.defaultUri, multiplyRequest, soapActionCallback);
		
		return new ApiSoapResponseDTO(OperationEnum.MULTIPLY, multiplyResponse.getMultiplyResult());
	}
	
	/**
	 * Metodo que se encarga de dividir dos numeros
	 * @param numberA
	 * @param numberB
	 * @return ApiSoapResponseDTO
	 */
	@Override
	public ApiSoapResponseDTO getDivideResponse(int numberA, int numberB) {
		Divide divideRequest = new Divide();
		divideRequest.setIntA(numberA);
		divideRequest.setIntB(numberB);
				
		SoapActionCallback soapActionCallback = new SoapActionCallback(this.soapActionCallback.concat(OperationEnum.DIVIDE.getUrlSegment()));		
		DivideResponse divideResponse = (DivideResponse) this.getWebServiceTemplate().marshalSendAndReceive(this.defaultUri, divideRequest, soapActionCallback);
		
		return new ApiSoapResponseDTO(OperationEnum.DIVIDE, divideResponse.getDivideResult());
	}
}
