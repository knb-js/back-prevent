package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.EstadoContratoEntity;
import com.back.prev.mapper.EstadoContratoMapper;
import com.back.prev.service.EstadoContratoService;

@Service
public class EstadoContratoImpl implements EstadoContratoService{

	@Autowired
	private EstadoContratoMapper estadoContratoMapper;
	
	@Override
	public List<EstadoContratoEntity> findAllEstadoContrato() {
		return estadoContratoMapper.findAllEstadoContrato();
	}

}
