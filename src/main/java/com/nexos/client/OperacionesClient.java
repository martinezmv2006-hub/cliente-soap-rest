package com.nexos.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.nexos.wsdl.GetDivisionRequest;
import com.nexos.wsdl.GetDivisionResponse;
import com.nexos.wsdl.GetMultiplicacionRequest;
import com.nexos.wsdl.GetMultiplicacionResponse;
import com.nexos.wsdl.GetRestaRequest;
import com.nexos.wsdl.GetRestaResponse;
import com.nexos.wsdl.GetSumaRequest;
import com.nexos.wsdl.GetSumaResponse;

@Service
public class OperacionesClient extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(OperacionesClient.class);

  public GetSumaResponse getSuma(double valor1,double valor2) {

	    GetSumaRequest request = new GetSumaRequest();
	    request.setValor1(valor1);
	    request.setValor2(valor2);

    log.info("Requesting getSuma for valor1:" + valor1 +" valor2: "+ valor2);

    GetSumaResponse response = (GetSumaResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://localhost:8080/ws/operaciones", request,
            new SoapActionCallback(
                "http://nexos.com/gs_operaciones_web_service/GetSumaRequest"));

    return response;
  }
  
  public GetRestaResponse getResta(double valor1,double valor2) {

	    GetRestaRequest request = new GetRestaRequest();
	    request.setValor1(valor1);
	    request.setValor2(valor2);

  log.info("Requesting getResta for valor1:" + valor1 +" valor2: "+ valor2);

  GetRestaResponse response = (GetRestaResponse) getWebServiceTemplate()
      .marshalSendAndReceive("http://localhost:8080/ws/operaciones", request,
          new SoapActionCallback(
              "http://nexos.com/gs_operaciones_web_service/GetRestaRequest"));

  return response;
}
  
  public GetMultiplicacionResponse getMultiplicacion(double valor1,double valor2) {

	    GetMultiplicacionRequest request = new GetMultiplicacionRequest();
	    request.setValor1(valor1);
	    request.setValor2(valor2);

  log.info("Requesting getMultiplicacion for valor1:" + valor1 +" valor2: "+ valor2);

  GetMultiplicacionResponse response = (GetMultiplicacionResponse) getWebServiceTemplate()
      .marshalSendAndReceive("http://localhost:8080/ws/operaciones", request,
          new SoapActionCallback(
              "http://nexos.com/gs_operaciones_web_service/GetMultiplicacionRequest"));

  return response;
}
  
  public GetDivisionResponse getDivision(double valor1,double valor2) {

	    GetDivisionRequest request = new GetDivisionRequest();
	    request.setValor1(valor1);
	    request.setValor2(valor2);

  log.info("Requesting getDivision for valor1:" + valor1 +" valor2: "+ valor2);

  GetDivisionResponse response = (GetDivisionResponse) getWebServiceTemplate()
      .marshalSendAndReceive("http://localhost:8080/ws/operaciones", request,
          new SoapActionCallback(
              "http://nexos.com/gs_operaciones_web_service/GetDivisionRequest"));

  return response;
}

}