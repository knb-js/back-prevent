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
import com.back.prev.entity.RepresentanteEntity;
import com.back.prev.service.RepresentanteService;

@RestController
@RequestMapping("/representante")
public class RepresentanteController {
	
	@Autowired 
	private RepresentanteService representanteService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllRepresentante() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<RepresentanteEntity> listRepresentante = representanteService.findAllRepresentantes();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listRepresentante))
				.message(Objects.nonNull(listRepresentante) ? "Representantes obtenidos con exito" : "Ha ocurrido un error al obtener los representantes")
				.data(listRepresentante)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
}
