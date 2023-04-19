package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.RepresentanteEntity;
import com.back.prev.mapper.RepresentanteMapper;
import com.back.prev.service.RepresentanteService;

@Service
public class RepresentanteServiceImpl implements RepresentanteService{
	
	@Autowired
	private RepresentanteMapper representanteMapper;
	
	@Override
	public List<RepresentanteEntity> findAllRepresentantes() {
		
		return representanteMapper.findAllRepresentantes();
	}

}
