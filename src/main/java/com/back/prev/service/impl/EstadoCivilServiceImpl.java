package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.EstadoCivilEntity;
import com.back.prev.mapper.EstadoCivilMapper;
import com.back.prev.service.EstadoCivilService;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService{

	@Autowired
	private EstadoCivilMapper estadoCivilMapper;
	
	@Override
	public List<EstadoCivilEntity> findAllEstadoCivil() {
		return estadoCivilMapper.findAllEstadoCivil();
	}

}
