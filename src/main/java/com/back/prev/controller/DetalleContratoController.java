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

import com.back.prev.dto.ResponseDTO;
import com.back.prev.entity.DetalleContratoEntity;
import com.back.prev.service.DetalleContratoService;

@RestController
@RequestMapping("/detalleContrato")
public class DetalleContratoController {

	@Autowired
	private DetalleContratoService detalleContratoService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllDetalleContrato() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<DetalleContratoEntity> listDetalle = detalleContratoService.findAllDetalleContrato();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listDetalle))
				.message(Objects.nonNull(listDetalle) ? "Detalle de Contratos obtenidos con éxito" : "Ha ocurrido un error al obtener los detalles de los contratos")
				.data(listDetalle)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/getByIdDetalleContrato/{idDetalleContrato}")
	public ResponseEntity<ResponseDTO> findByIdDetalleContrato(@PathVariable("idDetalleContrato") Integer idDetalleContrato){		
		try {
			DetalleContratoEntity detalle = detalleContratoService.findByIdDetalleContrato(idDetalleContrato);
			return new ResponseEntity<ResponseDTO>(ResponseDTO
					.builder()
					.status(Objects.nonNull(detalle))
					.message(Objects.nonNull(detalle) ? "Detalle de contrato obtenido con éxito" : "Ha ocurrido un error al obtener los detalles de los contratos por Id")
					.data(detalle)
					.build(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDTO>(
					ResponseDTO
					.builder()
					.status(false)
					.message("Error al obtener el Detalle Contrato: "+ e.getMessage())
					.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/insertDetalleContrato")
	public ResponseEntity<ResponseDTO> insertDetalleContrato(@RequestBody DetalleContratoEntity detalleContrato){
		ResponseDTO resp = ResponseDTO.builder().build();
		Integer insertDetalle = detalleContratoService.insertDetalleContrato(detalleContrato);
		resp = ResponseDTO
				.builder()
				.status(insertDetalle > 0)
				.message(insertDetalle > 0 ? "Detalle del contrato Agregado con Éxito" : "Ha ocurrido un error al agregar el detalle del contrato")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
}
