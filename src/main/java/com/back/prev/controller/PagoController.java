package com.back.prev.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.prev.dto.PaymentDTO;
import com.back.prev.dto.ResponseDTO;
import com.back.prev.entity.PagoEntity;
import com.back.prev.service.PagoService;

@RestController
@RequestMapping("/pagos")
public class PagoController {

	@Autowired
	private PagoService pagoService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllPago() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<PagoEntity> listPagos = pagoService.findAllPago();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listPagos))
				.message(Objects.nonNull(listPagos) ? "Pagos obtenidos con éxito" : "Ha ocurrido un error al obtener los pagos")
				.data(listPagos)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/getByIdPago/{idPago}")
	public ResponseEntity<ResponseDTO> findByIdPago(@PathVariable("idPago") Integer idPago){		
		try {
			PagoEntity pago = pagoService.findByIdPago(idPago);
			return new ResponseEntity<ResponseDTO>(ResponseDTO
					.builder()
					.status(Objects.nonNull(pago))
					.message(Objects.nonNull(pago) ? "Pago obtenido con éxito" : "Ha ocurrido un error al obtener el pago por Id")
					.data(pago)
					.build(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDTO>(
					ResponseDTO
					.builder()
					.status(false)
					.message("Error al obtener el pago: "+ e.getMessage())
					.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/insertPago")
	public ResponseEntity<ResponseDTO> insertPago(@RequestBody PagoEntity pago){
		ResponseDTO resp = ResponseDTO.builder().build();
		Integer insertPago = pagoService.insertPago(pago);
		resp = ResponseDTO
				.builder()
				.status(insertPago > 0)
				.message(insertPago > 0 ? "Pago Realizado con Éxito" : "Ha ocurrido un error al realizar el pago")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PostMapping("/generatePayment")
	public ResponseEntity<ResponseDTO> generatePago(@RequestBody PaymentDTO pago){
		ResponseDTO resp = ResponseDTO.builder().build();
		Boolean insertPago = pagoService.generatePago(pago);
		resp = ResponseDTO
				.builder()
				.status(insertPago)
				.message(insertPago ? "Pago Realizado con Éxito" : "Ha ocurrido un error al realizar el pago")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PostMapping("/generatePayment/{idContrato}/{monto}/{idUser}")
	public ResponseEntity<ResponseDTO> generatePagoContrato(@PathVariable("idContrato") Integer idContrato,@PathVariable("monto") Integer monto,@PathVariable("idUser") Integer idUser){
		ResponseDTO resp = ResponseDTO.builder().build();
		Boolean insertPago = pagoService.generatePagoRev(idContrato, monto, idUser);
		resp = ResponseDTO
				.builder()
				.status(insertPago)
				.message(insertPago ? "Pago Realizado con Éxito" : "Ha ocurrido un error al realizar el pago")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
}
