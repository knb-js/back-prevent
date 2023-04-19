package com.back.prev.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.prev.dto.ResponseDTO;
import com.back.prev.entity.TipoPlanEntity;
import com.back.prev.service.TipoPlanService;

@RestController
@RequestMapping("/Planes")
public class TipoPlanController {
	
	@Autowired TipoPlanService tipoPlanService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> findAllTipoPlan() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<TipoPlanEntity> listarPlan = tipoPlanService.findAllTipoPlan();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listarPlan))
				.message(Objects.nonNull(listarPlan) ? "Tipos de Plan obtenidos con exito" : "Ha ocurrido un error al obtener los Planes")
				.data(listarPlan)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/findByIdTipoPlan/{idTipoPlan}")
	public ResponseEntity<ResponseDTO> findByIdTipoPlan(@PathVariable("idTipoPlan") Integer idTipoPlan){		
		try {
			TipoPlanEntity plan = tipoPlanService.findByIdTipoPlan(idTipoPlan);
			return new ResponseEntity<ResponseDTO>(ResponseDTO
					.builder()
					.status(Objects.nonNull(plan))
					.message(Objects.nonNull(plan) ? "Plan obtenido con exito" : "Ha ocurrido un error al obtener el plan por Id")
					.data(plan)
					.build(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDTO>(
					ResponseDTO
					.builder()
					.status(false)
					.message("Error al obtener el plan: "+ e.getMessage())
					.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateTipoPlan")
	public ResponseEntity<ResponseDTO> updateTipoPlan(@RequestBody TipoPlanEntity tipoPlan){
		ResponseDTO resp = ResponseDTO.builder().build();
		
		Integer updatePlan = tipoPlanService.updateTipoPlan(tipoPlan);
		
		resp = ResponseDTO
				.builder()
				.status(updatePlan > 0 )
				.message(updatePlan > 0 ? "Plan actualizado" : "No se ha logrado actualizar el plan")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PostMapping("/insertTipoPlan")
	public ResponseEntity<ResponseDTO> insertTipoPlan(@RequestBody TipoPlanEntity tipoPlan){
		ResponseDTO resp = ResponseDTO.builder().build();
		Integer insertarPlan = tipoPlanService.insertTipoPlan(tipoPlan);
		resp = ResponseDTO
				.builder()
				.status(insertarPlan > 0)
				.message(insertarPlan > 0 ? "Plan Agregado con Exito" : "Ha ocurrido un error al agregar el plan")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTipoPlan/{idTipoPlan}")
	public ResponseEntity<ResponseDTO> deleteByIdTipoPlan(@PathVariable("idTipoPlan") Integer idTipoPlan) {
		ResponseDTO resp = ResponseDTO.builder().build();
		Integer deletePlan =  tipoPlanService.deleteByIdTipoPlan(idTipoPlan);
		resp = ResponseDTO
				.builder()
				.status(deletePlan > 0)
				.message(deletePlan > 0 ? "Plan eliminado con exito" : "Ha ocurrido un error al eliminar el plan")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
}
