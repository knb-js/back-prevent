package com.back.prev.service;

import java.util.List;

import com.back.prev.dto.PaymentDTO;
import com.back.prev.entity.PagoEntity;

public interface PagoService {

	List<PagoEntity> findAllPago();
	
	PagoEntity findByIdPago(Integer idPago);
	
	Integer insertPago(PagoEntity pago);
	
	Boolean generatePago(PaymentDTO pago);
	
	Boolean generatePagoRev(Integer idContrato,Integer monto,Integer idUser);
}
