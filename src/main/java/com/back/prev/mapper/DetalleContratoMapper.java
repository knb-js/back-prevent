package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.back.prev.entity.DetalleContratoEntity;

@Mapper
public interface DetalleContratoMapper {
	
	@Select("SELECT DC.ID_DETALLE_CONTRATO AS idDetalleContrato,	"
			+ "       C.ID_CONTRATO AS \"contrato.idContrato\",	"
			+ "       S.ID_SERVICIO AS \"servicio.idServicio\",	"
			+ "       DC.PRECIO	"
			+ "FROM DETALLE_CONTRATO DC	"
			+ "LEFT JOIN CONTRATO C on DC.ID_CONTRATO = C.ID_CONTRATO	"
			+ "LEFT JOIN SERVICIOS S on DC.ID_SERVICIO = S.ID_SERVICIO	")
	List<DetalleContratoEntity> findAllDetalleContrato();
	
	@Select("SELECT DC.ID_DETALLE_CONTRATO AS idDetalleContrato,	"
			+ "       C.ID_CONTRATO AS \"contrato.idContrato\",	"
			+ "       S.ID_SERVICIO AS \"servicio.idServicio\",	"
			+ "       DC.PRECIO	"
			+ "FROM DETALLE_CONTRATO DC	"
			+ "LEFT JOIN CONTRATO C on DC.ID_CONTRATO = C.ID_CONTRATO	"
			+ "LEFT JOIN SERVICIOS S on DC.ID_SERVICIO = S.ID_SERVICIO	"
			+ "WHERE ID_DETALLE_CONTRATO =#{idDetalleContrato}")
	DetalleContratoEntity findByIdDetalleContrato(Integer idDetalleContrato);
	
	@Insert("INSERT INTO DETALLE_CONTRATO (ID_CONTRATO, ID_SERVICIO, PRECIO )	"
			+ "    VALUES (#{contrato.idContrato}, #{servicio.idServicio}, #{precio})")
	Integer insertDetalleContrato (DetalleContratoEntity detalleContrato);
	
}
