package com.back.prev.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.prev.dto.ResponseDTO;
import com.back.prev.dto.ResponsePageHelperContrato;
import com.back.prev.entity.ContratoEntity;
import com.back.prev.service.ContratoService;
import com.github.pagehelper.Page;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
	
	@Autowired
	private ContratoService contratoService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllContrato() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<ContratoEntity> listContrato = contratoService.findAllContrato();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listContrato))
				.message(Objects.nonNull(listContrato) ? "Contratos obtenidos con éxito" : "Ha ocurrido un error al obtener los contratos")
				.data(listContrato)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PostMapping("/insertContrato")
	public ResponseEntity<ResponseDTO> insertContrato(@RequestBody ContratoEntity contrato){
		ResponseDTO resp = ResponseDTO.builder().build();
		Integer insertContrato = contratoService.insertContrato(contrato);
		resp = ResponseDTO
				.builder()
				.status(insertContrato > 0)
				.message(insertContrato > 0 ? "Contrato creado con Éxito" : "Ha ocurrido un error al crear el contrato")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/pageContrato/{fechaContratacion}/{fechaTermino}/{idUser}")
	public ResponseEntity<ResponseDTO> findAllPageContrato(@PathVariable("fechaContratacion") String fechaContratacion,@PathVariable("fechaTermino") String fechaTermino,@PathVariable("idUser") String idUser) {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		Page<ContratoEntity> listarContrato = contratoService.findAllPageContrato(fechaContratacion, fechaTermino, idUser);

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listarContrato))
				.message(Objects.nonNull(listarContrato) ? "Contratos obtenidos con éxito" : "Ha ocurrido un error al obtener los Contratos")
				.data(ResponsePageHelperContrato.builder().page(listarContrato).build())
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PutMapping("/updateContrato/{idContrato}/{field}/{value}")
	public ResponseEntity<ResponseDTO> update(@PathVariable("idContrato") Integer idContrato,@PathVariable("field") String field,@PathVariable("value") String value){
		ResponseDTO resp = ResponseDTO.builder().build();
		
		Integer updateUser = contratoService.updateContratoByField(idContrato, field, value);
		
		resp = ResponseDTO
				.builder()
				.status(updateUser > 0 )
				.message(updateUser > 0 ? "Usuario actualizado" : "No se ha logrado actualizar")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
}
