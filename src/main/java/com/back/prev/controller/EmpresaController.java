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
import com.back.prev.entity.EmpresaEntity;
import com.back.prev.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllEmpresa(){
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<EmpresaEntity> listEmpresa  = empresaService.findAllEmpresa();
		
		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listEmpresa))
				.message(Objects.nonNull(listEmpresa) ? "Empresas obtenidas con éxito" : "Ha ocurrido un error al obtener las empresas")
				.data(listEmpresa)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}

}
