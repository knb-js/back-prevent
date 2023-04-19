package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.EmpresaEntity;
import com.back.prev.mapper.EmpresaMapper;
import com.back.prev.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	private EmpresaMapper empresaMapper;
	
	@Override
	public List<EmpresaEntity> findAllEmpresa() {
	
		return empresaMapper.findAllEmpresa();
		
	}

}
