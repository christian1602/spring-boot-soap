package com.christian.soap;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import com.christian.soap.client.SoapClient;
//import com.christian.soap.wsdl.AddResponse;

@SpringBootApplication
public class SpringSoapApplication {
	
//	private static final Logger LOGGER = LoggerFactory.getLogger(SpringSoapApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner init(SoapClient soapClient) {
//	return args -> {
//			AddResponse addResponse = soapClient.getAddResponse(1, 4);			
//			LOGGER.info("El resultado de la suma de los numeros {} y {} es: {}", 1, 4, addResponse.getAddResult());
//		};
//	}
}
