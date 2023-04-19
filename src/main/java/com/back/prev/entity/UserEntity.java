package com.back.prev.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@EntityScan(basePackageClasses = { UserEntity.class })
public class UserEntity {

	private Integer idUser;
	private String login;
	private String address;
	private String startDate;
	private String birthday;
	private String username;
	private Integer rut;
	private String dv;
	private String name;
	private String lastName;
	private String contactPhone;
	private String email;
	private String corporateEmail;
	private String image;
	private String passwd;
	private String lastConnection;
	private String firstSession;
	private String verified;
	private String active;
	private String created;
	private String updated;
	private ProfileEntity profile;
	private NacionalidadEntity nacionalidad;
	private GeneroEntity genero;
	private ComunaEntity comuna;
	private EstadoCivilEntity estadoCivil;
	
}
