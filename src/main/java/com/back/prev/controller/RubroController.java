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
import com.back.prev.entity.RubroEntity;
import com.back.prev.service.RubroService;

@RestController
@RequestMapping("/rubro")
public class RubroController {

	@Autowired 
	private RubroService rubroService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllComuna() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<RubroEntity> listRubro = rubroService.findAllRubro();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listRubro))
				.message(Objects.nonNull(listRubro) ? "Rubros obtenidos con éxito" : "Ha ocurrido un error al obtener los rubros")
				.data(listRubro)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
}
