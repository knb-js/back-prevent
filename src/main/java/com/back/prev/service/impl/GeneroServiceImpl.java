package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.GeneroEntity;
import com.back.prev.mapper.GeneroMapper;
import com.back.prev.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroMapper generoMapper;
	
	@Override
	public List<GeneroEntity> findAllGenero() {
		return generoMapper.findAllGenero();
	}

}
