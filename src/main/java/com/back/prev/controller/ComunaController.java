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
import com.back.prev.entity.ComunaEntity;
import com.back.prev.service.ComunaService;

@RestController
@RequestMapping("/comuna")
public class ComunaController {
	
	@Autowired 
	private ComunaService comunaService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllComuna() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<ComunaEntity> listComuna = comunaService.findAllComuna();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listComuna))
				.message(Objects.nonNull(listComuna) ? "Comunas obtenidas con exito" : "Ha ocurrido un error al obtener las comunas")
				.data(listComuna)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}

}
