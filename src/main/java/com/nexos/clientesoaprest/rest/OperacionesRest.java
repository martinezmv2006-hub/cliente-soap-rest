package com.nexos.clientesoaprest.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.client.OperacionesClient;
import com.nexos.wsdl.GetDivisionResponse;
import com.nexos.wsdl.GetMultiplicacionResponse;
import com.nexos.wsdl.GetRestaResponse;
import com.nexos.wsdl.GetSumaResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
@Api(tags = "operaciones")
class OperacionesRest {
	
	@Autowired
	OperacionesClient client;
		
		@GetMapping(value="/suma")
		@ApiOperation(value = "Operación Suma", notes = "Servicio que realiza la suma de 2 valores enviados")
		@ApiResponses(value = {@ApiResponse(code = 201, message = "Operación realizada")})
		@ApiResponse(code = 404, message = "Operación no realizada")
		public ResponseEntity<Double> getSuma(@RequestParam(name = "valor1") double valor1,@RequestParam(name = "valor2") double valor2){
	        GetSumaResponse response = client.getSuma(valor1, valor2);
	        return ResponseEntity.ok(response.getValorTotal());
		}
		
		@GetMapping(value="/resta")
		@ApiOperation(value = "Operación Resta", notes = "Servicio que realiza la resta de 2 valores enviados")
		@ApiResponses(value = {@ApiResponse(code = 201, message = "Operación realizada")})
		@ApiResponse(code = 404, message = "Operación no realizada")
		public ResponseEntity<Double> getResta(@RequestParam(name = "valor1") double valor1,@RequestParam(name = "valor2") double valor2){
	        GetRestaResponse response = client.getResta(valor1, valor2);
	        return ResponseEntity.ok(response.getValorTotal());
		}
		
		@GetMapping(value="/multiplicacion")
		@ApiOperation(value = "Operación Multiplicación", notes = "Servicio que realiza la multiplicación de 2 valores enviados")
		@ApiResponses(value = {@ApiResponse(code = 201, message = "Operación realizada")})
		@ApiResponse(code = 404, message = "Operación no realizada")
		public ResponseEntity<Double> getMultiplicacion(@RequestParam(name = "valor1") double valor1,@RequestParam(name = "valor2") double valor2){
	        GetMultiplicacionResponse response = client.getMultiplicacion(valor1, valor2);
	        return ResponseEntity.ok(response.getValorTotal());
		}
		
		@GetMapping(value="/division")
		@ApiOperation(value = "Operación División", notes = "Servicio que realiza la División de 2 valores enviados")
		@ApiResponses(value = {@ApiResponse(code = 201, message = "Operación realizada")})
			@ApiResponse(code = 404, message = "Operación no realizada")
		public ResponseEntity<Double> getDivision(@RequestParam(name = "valor1") double valor1,@RequestParam(name = "valor2") double valor2){
	        GetDivisionResponse response = client.getDivision(valor1, valor2);
	        return ResponseEntity.ok(response.getValorTotal());
		}
		
		@GetMapping(value="/pendiente")
		@ApiOperation(value = "Calcular la Pendiente", notes = "Servicio que Calcular la Pendiente")
		@ApiResponses(value = {@ApiResponse(code = 201, message = "Operación realizada")})
		@ApiResponse(code = 404, message = "Operación no realizada")
		public ResponseEntity<Double> getPendiente(@RequestParam(name = "y1") double y1,@RequestParam(name = "y2") double y2,@RequestParam(name = "x1") double x1,@RequestParam(name = "x2") double x2){
			GetRestaResponse resta1 = client.getResta(y2, y1);
			GetRestaResponse response2 = client.getResta(x2, x1);
	        GetDivisionResponse response = client.getDivision(resta1.getValorTotal(), response2.getValorTotal());
	        return ResponseEntity.ok(response.getValorTotal());
		}
		
		@GetMapping(value="/promedio")
		@ApiOperation(value = "Calcular el promedio", notes = "Servicio que Calcular la Promedio de una lista de numeros")
		@ApiResponses(value = {@ApiResponse(code = 201, message = "Operación realizada")})
		@ApiResponse(code = 404, message = "Operación no realizada")
		public ResponseEntity<Double> getPendiente(@RequestParam(name = "lista_valores") List<Double> lista_valores){
			Double count_valor = 0d;
			for(Double valor : lista_valores) {
				GetSumaResponse response = client.getSuma(count_valor, valor);
				count_valor = response.getValorTotal();
			}
	        GetDivisionResponse response = client.getDivision(count_valor, lista_valores.size());
	        return ResponseEntity.ok(response.getValorTotal());
		}
		
		@GetMapping(value="/area_triangulo")
		@ApiOperation(value = "Calcular el area de triandulo", notes = "Servicio que Calcular el area de un triangulo")
		@ApiResponses(value = {@ApiResponse(code = 201, message = "Operación realizada")})
		@ApiResponse(code = 404, message = "Operación no realizada")
		public ResponseEntity<Double> getAreaTriangulo(@RequestParam(name = "base") double base,@RequestParam(name = "altura") double altura){
			GetMultiplicacionResponse multiplicacion = client.getMultiplicacion(base, altura);
	        GetDivisionResponse response = client.getDivision(multiplicacion.getValorTotal(), 2);
	        return ResponseEntity.ok(response.getValorTotal());
		}
		
		@GetMapping(value="/area_circulo")
		@ApiOperation(value = "Calcular el area de circulo", notes = "Servicio que Calcular el area de un circulo")
		@ApiResponses(value = {@ApiResponse(code = 201, message = "Operación realizada")})
		@ApiResponse(code = 404, message = "Operación no realizada")
		public ResponseEntity<Double> getAreaRadio(@RequestParam(name = "radio") double radio){
			GetMultiplicacionResponse multiplicacion = client.getMultiplicacion(radio, radio);
			GetMultiplicacionResponse response = client.getMultiplicacion(3.141592,multiplicacion.getValorTotal());
	        return ResponseEntity.ok(response.getValorTotal());
		}

}
