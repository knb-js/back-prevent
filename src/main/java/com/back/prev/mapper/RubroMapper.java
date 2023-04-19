package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.back.prev.entity.RubroEntity;

@Mapper
public interface RubroMapper {
	
	@Select("SELECT ID_RUBRO AS idRubro,"
			+ "	DESCRIPCION"
			+ "	FROM RUBRO")
	List<RubroEntity> findAllRubro();
}
