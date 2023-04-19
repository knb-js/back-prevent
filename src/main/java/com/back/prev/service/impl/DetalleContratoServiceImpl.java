package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.DetalleContratoEntity;
import com.back.prev.mapper.DetalleContratoMapper;
import com.back.prev.service.DetalleContratoService;

@Service
public class DetalleContratoServiceImpl implements DetalleContratoService{

	@Autowired
	private DetalleContratoMapper detalleContratoMapper;
	
	@Override
	public List<DetalleContratoEntity> findAllDetalleContrato() {
		return detalleContratoMapper.findAllDetalleContrato();
	}

	@Override
	public DetalleContratoEntity findByIdDetalleContrato(Integer idDetalleContrato) {
		return detalleContratoMapper.findByIdDetalleContrato(idDetalleContrato);
	}

	@Override
	public Integer insertDetalleContrato(DetalleContratoEntity detalleContrato) {
		return detalleContratoMapper.insertDetalleContrato(detalleContrato);
	}

}
