package com.back.prev.service;

import java.util.List;

import com.back.prev.entity.TipoPlanEntity;

public interface TipoPlanService {

	List<TipoPlanEntity> findAllTipoPlan();
	
	TipoPlanEntity findByIdTipoPlan(Integer idTipoPlan);
	
	Integer insertTipoPlan(TipoPlanEntity tipoPlan);
	
	Integer updateTipoPlan(TipoPlanEntity tipoPlan);
	
	Integer deleteByIdTipoPlan(Integer idTipoPlan);
	
}
