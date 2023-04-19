package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.back.prev.entity.EmpresaEntity;

@Mapper
public interface EmpresaMapper {
	
	@Select("SELECT E.ID_EMPRESA AS idEmpresa,	"
			+ "				E.NOMBRE_EMPR,	"
			+ "			    E.DIRECCION,	"
			+ "			    E.CORREOCONTACTO,	"
			+ "				C.ID_COMUNA	as	\"comuna.idComuna\",	"
			+ "			    R.ID_RUBRO	as	\"rubro.idRubro\" 	"
			+ "				FROM EMPRESA E	"
			+ "		        LEFT JOIN COMUNA C on E.COMUNA_ID_COMUNA	=	C.ID_COMUNA	"
			+ "		        LEFT JOIN RUBRO R on E.RUBRO_ID_RUBRO		=	R.ID_RUBRO	"
			)	
	List<EmpresaEntity> findAllEmpresa();
}
