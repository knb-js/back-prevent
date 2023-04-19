package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.ContratoEntity;
import com.back.prev.mapper.ContratoMapper;
import com.back.prev.service.ContratoService;
import com.github.pagehelper.Page;

@Service
public class ContratoServiceImpl implements ContratoService{
	
	@Autowired
	private ContratoMapper contratoMapper;
		
	@Override
	public List<ContratoEntity> findAllContrato() {
		return contratoMapper.findAllContrato();
	}

	@Override
	public Integer insertContrato(ContratoEntity contrato) {
		return contratoMapper.insertContrato(contrato);
	}

	@Override
	public Page<ContratoEntity> findAllPageContrato(String fechaContratacion, String fechaTermino, String idUser) {
		//fechaTermino = fechaTermino.replaceAll("-", "/");
		System.out.println(fechaTermino);
		return contratoMapper.findAllPageContrato(fechaContratacion, fechaTermino, idUser);
	}

	@Override
	public Integer updateContratoByField(Integer idContrato, String field, String value) {
		return contratoMapper.updateContratoByField(idContrato, field, value);
	}

}
