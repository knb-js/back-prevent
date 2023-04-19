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
import com.back.prev.entity.GeneroEntity;
import com.back.prev.service.GeneroService;

@RestController
@RequestMapping("/genero")
public class GeneroController {

	@Autowired
	private GeneroService generoService;
	
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllGenero() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<GeneroEntity> listGeneros = generoService.findAllGenero();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listGeneros))
				.message(Objects.nonNull(listGeneros) ? "Generos obtenidos con exito" : "Ha ocurrido un error al obtener los Generos")
				.data(listGeneros)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
}
