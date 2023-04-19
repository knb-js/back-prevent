package com.back.prev.service;

import java.util.List;

import com.back.prev.entity.ContratoEntity;
import com.github.pagehelper.Page;

public interface ContratoService {
	
	List<ContratoEntity> findAllContrato();
	
	Integer insertContrato (ContratoEntity contrato);
	
	Page<ContratoEntity> findAllPageContrato(String fechaContratacion, String fechaTermino, String idUser);
	
	Integer updateContratoByField(Integer idContrato, String field, String value);
}
