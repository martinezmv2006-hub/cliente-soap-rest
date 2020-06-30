package com.nexos.clientesoaprest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nexos.client.OperacionesClient;
import com.nexos.wsdl.GetSumaResponse;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages="com.nexos.clientesoaprest")
@EnableSwagger2
public class ClienteSoapRestApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ClienteSoapRestApplication.class, args);
	}
	
	@Bean
	  CommandLineRunner lookup(OperacionesClient quoteClient) {
	    return args -> {
	      String country = "Spain";

	      if (args.length > 0) {
	        country = args[0];
	      }
	      GetSumaResponse response = quoteClient.getSuma(5, 15);
	      System.err.println("TOTAL: "+response.getValorTotal());
	    };
	  }


}
