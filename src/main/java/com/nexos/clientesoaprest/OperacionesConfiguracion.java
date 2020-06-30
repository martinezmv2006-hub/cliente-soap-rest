package com.nexos.clientesoaprest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import com.nexos.client.OperacionesClient;
@Configuration
@ComponentScan
public class OperacionesConfiguracion {
 
   @Bean
   public Jaxb2Marshaller marshaller() {
	   Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	   marshaller.setContextPath("com.nexos.wsdl");
	   return marshaller;
   }
   
   @Bean
   public OperacionesClient operacionesClient(Jaxb2Marshaller marshaller) {
	   OperacionesClient operacion = new OperacionesClient();
	   operacion.setDefaultUri("http://localhost:8080/ws");
	   operacion.setMarshaller(marshaller);
	   operacion.setUnmarshaller(marshaller);
	   return operacion;
   }
}