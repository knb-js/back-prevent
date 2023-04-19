package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.back.prev.entity.RepresentanteEntity;

@Mapper
public interface RepresentanteMapper {
	
	@Select("SELECT R.ID_REPRE AS  idRepre,	"
			+ "       R.NOMBREREPRE	AS	,	"
			+ "       EE.ID_EMPRESA	as \"empresa.idEmpresa\"	"
			+ "		FROM REPRESENTANTE  R	"
			+ "    LEFT JOIN EMPRESA EE on R.EMPRESA_ID_EMPRESA = EE.ID_EMPRESA")
	List<RepresentanteEntity> findAllRepresentantes();
}
