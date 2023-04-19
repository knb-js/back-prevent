package com.back.prev.controller;

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

import com.back.prev.dto.EmailDTO;
import com.back.prev.dto.ResponseDTO;
import com.back.prev.dto.ResponsePageHelperUser;
import com.back.prev.entity.UserEntity;
import com.back.prev.service.EmailService;
import com.back.prev.service.UserService;
import com.github.pagehelper.Page;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(@RequestBody UserEntity user) {
		ResponseDTO resp = ResponseDTO.builder().build();

		UserEntity usrResp = userService.loginUser(user);
		
		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(usrResp))
				.message(Objects.nonNull(usrResp) ? "Usuario identificado con éxito" : "Credenciales nos son válidas.")
				.data(usrResp)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/pageUser/{rut}/{name}/{lastName}/{id_profile}/{email}")
	public ResponseEntity<ResponseDTO> findAllPage(@PathVariable("rut") String rut,@PathVariable("name") String name, @PathVariable("lastName") String lastName,@PathVariable("id_profile") String id_profile,@PathVariable("email") String email ) {
		ResponseDTO resp = ResponseDTO.builder().build();
		
		Page<UserEntity> listarUser = userService.findAllPage(rut, name, lastName, id_profile, email);

		resp = ResponseDTO
				.builder()
				.status(Objects.nonNull(listarUser))
				.message(Objects.nonNull(listarUser) ? "Usuarios obtenidos con exito" : "Ha ocurrido un error al obtener los usuarios")
				.data(ResponsePageHelperUser.builder().page(listarUser).build())
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PostMapping("/verifedMail")
	public ResponseEntity<ResponseDTO> verifedMail(@RequestBody EmailDTO email) {
		ResponseDTO resp = ResponseDTO.builder().build();
		emailService.sendEmailPassword(email);
		resp = ResponseDTO
				.builder()
				.status(true)
				.message("Envio de email....")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/getMailUser/{idUser}")
	public ResponseEntity<ResponseDTO> getMailUser(@PathVariable("idUser") Integer idUser) {
		ResponseDTO resp = ResponseDTO.builder().build();
		resp = ResponseDTO
				.builder()
				.status(true)
				.message("Envio de email....")
				.data(userService.getEmailUser(idUser))
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/updateVerified/{idUser}")
	public ResponseEntity<ResponseDTO> updateVerified(@PathVariable("idUser") Integer idUser) {
		ResponseDTO resp = ResponseDTO.builder().build();
		resp = ResponseDTO
				.builder()
				.status(true)
				.message("Actualización de verificado")
				.data(userService.updateVerified(idUser))
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{idUser}/{field}/{value}")
	public ResponseEntity<ResponseDTO> update(@PathVariable("idUser") Integer idService,@PathVariable("field") String field,@PathVariable("value") String value){
		ResponseDTO resp = ResponseDTO.builder().build();
		
		Integer updateUser = userService.updateUserByField(idService, field, value);
		
		resp = ResponseDTO
				.builder()
				.status(updateUser > 0 )
				.message(updateUser > 0 ? "Usuario actualizado" : "No se ha logrado actualizar")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PostMapping("/resetPasswordEmail")
	public ResponseEntity<ResponseDTO> resetPasswordEmail(@RequestBody EmailDTO email) {
		ResponseDTO resp = ResponseDTO.builder().build();
		userService.sendMailByEmail(email);
		resp = ResponseDTO
				.builder()
				.status(true)
				.message("Actualización de verificado")
				.data(true)
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PostMapping("/updatePassword")
	public ResponseEntity<ResponseDTO> updatePassword(@RequestBody UserEntity user) {
		ResponseDTO resp = ResponseDTO.builder().build();
		resp = ResponseDTO
				.builder()
				.status(true)
				.message("Actualización de verificado")
				.data(userService.updatePassword(user))
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> registerUser(@RequestBody UserEntity user) {
		ResponseDTO resp = ResponseDTO.builder().build();
		Integer register = userService.registerUser(user);
		resp = ResponseDTO
				.builder()
				.status(register == 1)
				.message(register == 1 ? "Usuario creado con exito": "Ocurrio un error al registrar")
				.build();
		return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
	}
	
}
