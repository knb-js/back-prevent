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
import com.back.prev.entity.NacionalidadEntity;
import com.back.prev.service.NacionalidadService;

@RestController
@RequestMapping("/nacionalidad")
public class NacionalidadController {
	
	@Autowired
	private NacionalidadService nacionalidadService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllNacionalidad() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<NacionalidadEntity> listNacionalidades = nacionalidadService.findAllNacionalidad();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listNacionalidades))
				.message(Objects.nonNull(listNacionalidades) ? "Nacionalidades obtenidas con exito" : "Ha ocurrido un error al obtener las nacionalidades")
				.data(listNacionalidades)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}

	
}
