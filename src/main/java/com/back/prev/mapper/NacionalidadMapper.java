package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.back.prev.entity.NacionalidadEntity;

@Mapper
public interface NacionalidadMapper {

	@Select("SELECT ID_NACIO AS idNacionalidad," +
		    "  DESCRIPCION"	+
		    " FROM NACIONALIDAD")
	List<NacionalidadEntity> findAllNacionalidad();
	
}
