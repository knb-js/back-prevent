package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.RubroEntity;
import com.back.prev.mapper.RubroMapper;
import com.back.prev.service.RubroService;

@Service
public class RubroServiceImpl implements RubroService{
	
	@Autowired
	private RubroMapper rubroMapper;
	
	@Override
	public List<RubroEntity> findAllRubro() {

		return rubroMapper.findAllRubro();
	}

}
