package com.back.prev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.entity.TipoPlanEntity;
import com.back.prev.mapper.TipoPlanMapper;
import com.back.prev.service.TipoPlanService;

@Service
public class TipoPlanServiceImpl implements TipoPlanService{
	
	@Autowired
	private TipoPlanMapper tipoPlanMapper;

	@Override
	public List<TipoPlanEntity> findAllTipoPlan() {
		return tipoPlanMapper.findAllTipoPlan();
	}

	@Override
	public TipoPlanEntity findByIdTipoPlan(Integer idTipoPlan) {
		return tipoPlanMapper.findByIdTipoPlan(idTipoPlan);
	}

	@Override
	public Integer insertTipoPlan(TipoPlanEntity tipoPlan) {
		return tipoPlanMapper.insertTipoPlan(tipoPlan);
	}

	@Override
	public Integer updateTipoPlan(TipoPlanEntity tipoPlan) {
		return tipoPlanMapper.updateTipoPlan(tipoPlan);
	}

	@Override
	public Integer deleteByIdTipoPlan(Integer idTipoPlan) {
		return tipoPlanMapper.deleteByIdTipoPlan(idTipoPlan);
	}

}
