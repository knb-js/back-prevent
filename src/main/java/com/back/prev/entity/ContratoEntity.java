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
public class ContratoEntity {	
	
	private Integer idContrato;
	private String comentario;
	private Integer valor;
	private Double valorExtra;
	private String fechaContratacion;
	private String fechaTermino;
	private String renovacion;
	private String capacitacion;
	private RepresentanteEntity representante;
	private EmpresaEntity empresa;
	private TipoPlanEntity tipoPlan;
	private EstadoContratoEntity estadoContrato;
	private Integer idUser;
}
