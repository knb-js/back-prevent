package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.back.prev.entity.EstadoContratoEntity;

@Mapper
public interface EstadoContratoMapper {
	
	@Select("SELECT ID_ESTADOCONTRA AS idEstadoContrato,"
			+ "	DESCRIPCION"
			+ "	FROM ESTADO_CONTRATO")
	List<EstadoContratoEntity> findAllEstadoContrato();
}
