package com.back.prev.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.prev.dto.ResponseDTO;
import com.back.prev.entity.EstadoContratoEntity;
import com.back.prev.service.EstadoContratoService;

@RestController
@RequestMapping("/estadoContrato")
public class EstadoContratoController {

	@Autowired
	private EstadoContratoService estadoContratoService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllEstadoContrato() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<EstadoContratoEntity> listEstadoContrato = estadoContratoService.findAllEstadoContrato();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listEstadoContrato))
				.message(Objects.nonNull(listEstadoContrato) ? "Estado de Contratos obtenidos con éxito" : "Ha ocurrido un error al obtener los estados de contrato")
				.data(listEstadoContrato)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}

}
