package com.back.prev.dto;

import java.util.List;

import com.back.prev.entity.ServicioEntity;
import com.back.prev.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class PaymentDTO {
	
	private UserEntity user;
	
	private List<ServicioEntity> servicios;

}
