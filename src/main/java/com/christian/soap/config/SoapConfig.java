package com.christian.soap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.christian.soap.service.ISoapClientService;
import com.christian.soap.service.SoapClientServiceImpl;

// CLASE DE CONFIGURACION NECESARIA PARA CONSUMIR EL API SOAP 
@Configuration
public class SoapConfig {
	
	@Value("${soap.marshaller.context-path}")
	private String contextPath;
	
	@Value("${soap.client.default-uri}")
	private String defaultUri;
	
	// BEAN NECESARIO PARA EL API SOAP
	@Bean
	Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(this.contextPath);
		return marshaller;
	}
	
	// BEAN NECESARIO PARA EL API SOAP
	// EN ESTE CASO EN PARTICULAR, ESTAMOS OBLIGADOS A USAR EL BEAN DE SoapClientServiceImpl PORQUE:
	// 1. DEFINE LOS METODOS DEL SOAP
	// 2. PERMITE USAR this.getWebServiceTemplate().marshalSendAndReceive QUE ES PROPIO DE WebServiceGatewaySupport
	// AHORA, CUANDO CREAS UN BEAN DENTRO DE UN @Configuration Y PIENSAS INYECTARLO MANUALMENTE EN ALGUN CONTROLADOR U OTRO COMPONENTE,
	// SE RECOMIENDA USAR @Primary PARA QUE SE USE ESTE BEAN POR DEFECTO, Y ASI EVITAR CONFLICOS SI HUBIERAN MAS DE UN BEAN DEL MISMO TIPO
	@Primary
	@Bean
	ISoapClientService soapClient(Jaxb2Marshaller marshaller) {
		SoapClientServiceImpl soapClient = new SoapClientServiceImpl();
		soapClient.setDefaultUri(this.defaultUri);
		soapClient.setMarshaller(marshaller);
		soapClient.setUnmarshaller(marshaller);
		return soapClient;
	}
}
