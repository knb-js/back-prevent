package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.ComunaEntity;
import com.back.prev.mapper.ComunaMapper;
import com.back.prev.service.ComunaService;

@Service
public class ComunaServiceImpl implements ComunaService {

	@Autowired
	private ComunaMapper comunaMapper;
	
	@Override
	public List<ComunaEntity> findAllComuna() {
		return comunaMapper.findAllComuna();
	}

}
