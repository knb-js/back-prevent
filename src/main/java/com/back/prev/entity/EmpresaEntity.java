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
public class EmpresaEntity {
	
	private Integer idEmpresa;
	private String nombreEmpresa;
	private String direccion;
	private String correoContacto;
	private ComunaEntity comuna;
	private RubroEntity rubro;
	
}
