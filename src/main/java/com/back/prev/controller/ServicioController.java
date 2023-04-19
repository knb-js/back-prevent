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
import com.back.prev.dto.ResponsePageHelper;
import com.back.prev.entity.ServicioEntity;
import com.back.prev.service.ServicioService;
import com.github.pagehelper.Page;


@RestController
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	private ServicioService servicioService;

	@GetMapping
	public ResponseEntity<ResponseDTO> findAll() {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		List<ServicioEntity> listServicios = servicioService.findAll();

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listServicios))
				.message(Objects.nonNull(listServicios) ? "Servicios obtenidos con exito" : "Ha ocurrido un error al obtener los servicios")
				.data(listServicios)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/page/{nombre}/{descripcion}")
	public ResponseEntity<ResponseDTO> findAllPagex(@PathVariable("nombre") String nombre,@PathVariable("descripcion") String descripcion) {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		Page<ServicioEntity> listServicios = servicioService.findAllPage(nombre,descripcion);

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listServicios))
				.message(Objects.nonNull(listServicios) ? "Servicios obtenidos con exito" : "Ha ocurrido un error al obtener los servicios")
				.data(ResponsePageHelper.builder().page(listServicios).build())
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}

	@GetMapping("/getById/{idServicio}")
	public ResponseEntity<ResponseDTO> findById(@PathVariable("idServicio") Integer idServicio){		
		try {
			ServicioEntity servicio = servicioService.findById(idServicio);
			return new ResponseEntity<ResponseDTO>(ResponseDTO
					.builder()
					.status(Objects.nonNull(servicio))
					.message(Objects.nonNull(servicio) ? "Servicio obtenido con exito" : "Ha ocurrido un error al obtener el servicio por Id")
					.data(servicio)
					.build(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDTO>(
					ResponseDTO
					.builder()
					.status(false)
					.message("Error al obtener el servicio: "+ e.getMessage())
					.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> update(@RequestBody ServicioEntity servicio){
		ResponseDTO resp = ResponseDTO.builder().build();
		
		Integer updateService = servicioService.update(servicio);
		
		resp = ResponseDTO
				.builder()
				.status(updateService > 0 )
				.message(updateService > 0 ? "Servicio actualizado" : "No se ha logrado actualizar")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PutMapping("/update/{idService}/{field}/{value}")
	public ResponseEntity<ResponseDTO> update(@PathVariable("idService") Integer idService,@PathVariable("field") String field,@PathVariable("value") String value){
		ResponseDTO resp = ResponseDTO.builder().build();
		
		Integer updateService = servicioService.updateServiceByField(idService, field, value);
		
		resp = ResponseDTO
				.builder()
				.status(updateService > 0 )
				.message(updateService > 0 ? "Servicio actualizado" : "No se ha logrado actualizar")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<ResponseDTO> insert(@RequestBody ServicioEntity servicio){
		ResponseDTO resp = ResponseDTO.builder().build();
		Integer insertarServicio = servicioService.insert(servicio);
		resp = ResponseDTO
				.builder()
				.status(insertarServicio > 0)
				.message(insertarServicio > 0 ? "Servicio Agregado con Exito" : "Ha ocurrido un error al agregar el servicio")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{idServicio}")
	public ResponseEntity<ResponseDTO> deleteById(@PathVariable("idServicio") Integer idServicio) {
		ResponseDTO resp = ResponseDTO.builder().build();
		Integer deleteServicio =  servicioService.deleteById(idServicio);
		resp = ResponseDTO
				.builder()
				.status(deleteServicio > 0)
				.message(deleteServicio > 0 ? "Servicios eliminado con exito" : "Ha ocurrido un error al eliminar el servicio")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}

}
