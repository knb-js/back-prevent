package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.back.prev.entity.EstadoCivilEntity;

@Mapper
public interface EstadoCivilMapper {
	
	@Select("SELECT ID_ESTADOCIVIL AS idEstadoCivil,"
			+ "       DESCRIPCION"
			+ "	FROM ESTADO_CIVIL")
	List<EstadoCivilEntity> findAllEstadoCivil();
	
}
