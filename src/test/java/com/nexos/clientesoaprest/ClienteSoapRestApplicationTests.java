package com.nexos.clientesoaprest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.nexos.client.OperacionesClient;
import com.nexos.wsdl.GetDivisionResponse;
import com.nexos.wsdl.GetMultiplicacionResponse;
import com.nexos.wsdl.GetRestaResponse;
import com.nexos.wsdl.GetSumaResponse;

@SpringBootTest
class ClienteSoapRestApplicationTests  {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	OperacionesClient client;
 
    @Test
    void obtenerSumaService() {
        GetSumaResponse response = client.getSuma(5, 10);
        assertEquals(15.0, response.getValorTotal(),0.001);
    }
 
    @Test
    void obtenerRestaService() {
        GetRestaResponse response = client.getResta(10, 5);
        assertEquals(5, response.getValorTotal(),0.001);
    }
    
    @Test
    void obtenerMultiplicacionService() {
        GetMultiplicacionResponse response = client.getMultiplicacion(2, 8);
        assertEquals(16, response.getValorTotal(),0.001);
    }
    
    @Test
    void obtenerDivisionService() {
        GetDivisionResponse response = client.getDivision(8, 2);
        assertEquals(4, response.getValorTotal(),0.001);
    }

}
