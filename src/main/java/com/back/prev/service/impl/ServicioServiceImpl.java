package com.back.prev.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.ServicioEntity;
import com.back.prev.mapper.ServicioMapper;
import com.back.prev.service.ServicioService;
import com.github.pagehelper.Page;

@Service
public class ServicioServiceImpl implements ServicioService {

	@Autowired
	private ServicioMapper servicioMapper;

	@Override
	public List<ServicioEntity> findAll() {
		return servicioMapper.findAll();
	}
	
	@Override
	public Page<ServicioEntity> findAllPage(String nombre, String descripcion) {
		return servicioMapper.findAllPage(nombre,descripcion);
	}
	

	@Override
	public ServicioEntity findById(Integer idServicio) {
		return servicioMapper.findById(idServicio);
	}

	@Override
	public Integer insert(ServicioEntity servicio) {
		servicio.setActive("Y");
		return servicioMapper.insert(servicio);
	}

	@Override
	public Integer deleteById(Integer idServicio) {
		return servicioMapper.deleteById(idServicio);
	}

	@Override
	public Integer update(ServicioEntity servicio) {
		return servicioMapper.update(servicio);
	}

	@Override
	public Integer updateServiceByField(Integer idService, String field, String value) {
		return servicioMapper.updateServiceByField(idService, field, field.equals("image") ? decode(value) : value);
	}
	
	public String decode(String text) {
		return new String(Base64.getDecoder().decode(text));
	}
	
}
