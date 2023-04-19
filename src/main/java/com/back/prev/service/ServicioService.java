package com.back.prev.service;

import java.util.List;

import com.back.prev.entity.ServicioEntity;
import com.github.pagehelper.Page;

public interface ServicioService {

	List<ServicioEntity> findAll();
	
	Page<ServicioEntity> findAllPage(String nombre,String descripcion);

	ServicioEntity findById(Integer idServicio);

	Integer insert(ServicioEntity servicio);

	Integer update(ServicioEntity servicio);

	Integer deleteById(Integer idServicio);
	
	Integer updateServiceByField(Integer idService, String field, String value);

}
