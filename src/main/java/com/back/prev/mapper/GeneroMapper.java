package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.back.prev.entity.GeneroEntity;

@Mapper
public interface GeneroMapper {
	
	@Select("SELECT ID_GENERO AS idGenero,"
			+ " DESCRIPCION"
			+ "	FROM GENERO")
	List<GeneroEntity> findAllGenero();
	
}
