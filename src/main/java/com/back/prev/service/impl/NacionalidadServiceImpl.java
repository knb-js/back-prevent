package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.NacionalidadEntity;
import com.back.prev.mapper.NacionalidadMapper;
import com.back.prev.service.NacionalidadService;

@Service
public class NacionalidadServiceImpl implements NacionalidadService{

	@Autowired
	private NacionalidadMapper nacionalidadMapper;
	
	@Override
	public List<NacionalidadEntity> findAllNacionalidad() {
		return nacionalidadMapper.findAllNacionalidad();
	}

}
