package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.back.prev.entity.ComunaEntity;

@Mapper
public interface ComunaMapper {

	@Select("SELECT ID_COMUNA AS idComuna,"
			+ "	DESCRIPCION"
			+ "	FROM COMUNA")
	List<ComunaEntity> findAllComuna();
	
}
