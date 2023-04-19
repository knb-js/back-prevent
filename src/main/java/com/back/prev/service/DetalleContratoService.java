package com.back.prev.service;

import java.util.List;

import com.back.prev.entity.DetalleContratoEntity;

public interface DetalleContratoService {

	List<DetalleContratoEntity> findAllDetalleContrato();
	
	DetalleContratoEntity findByIdDetalleContrato(Integer idDetalleContrato);
	
	Integer insertDetalleContrato (DetalleContratoEntity detalleContrato);
}
