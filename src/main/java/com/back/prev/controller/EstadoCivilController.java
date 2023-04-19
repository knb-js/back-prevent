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
import com.back.prev.entity.EstadoCivilEntity;
import com.back.prev.service.EstadoCivilService;

@RestController
@RequestMapping("/estadoCivil")
public class EstadoCivilController {
	
	@Autowired
	EstadoCivilService estadoCivilService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllEstadoCivil() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<EstadoCivilEntity> listEstadoCivil = estadoCivilService.findAllEstadoCivil();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listEstadoCivil))
				.message(Objects.nonNull(listEstadoCivil) ? "Estados civiles obtenidos con exito" : "Ha ocurrido un error al obtener los estados civiles")
				.data(listEstadoCivil)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
}
