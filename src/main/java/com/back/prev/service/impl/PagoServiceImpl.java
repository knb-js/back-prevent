package com.back.prev.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.prev.dto.ContratosVencidosDTO;
import com.back.prev.dto.EmailDTO;
import com.back.prev.dto.PaymentDTO;
import com.back.prev.entity.ContratoEntity;
import com.back.prev.entity.DetalleContratoEntity;
import com.back.prev.entity.EmpresaEntity;
import com.back.prev.entity.EstadoContratoEntity;
import com.back.prev.entity.PagoEntity;
import com.back.prev.entity.RepresentanteEntity;
import com.back.prev.entity.ServicioEntity;
import com.back.prev.entity.TipoPlanEntity;
import com.back.prev.entity.UserEntity;
import com.back.prev.mapper.ContratoMapper;
import com.back.prev.mapper.DetalleContratoMapper;
import com.back.prev.mapper.PagoMapper;
import com.back.prev.service.EmailService;
import com.back.prev.service.PagoService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PagoServiceImpl implements PagoService{

	@Autowired
	private PagoMapper pagoMapper; 
	
	@Autowired
	private ContratoMapper contratoMapper;
	
	@Autowired
	private DetalleContratoMapper detalleContratoMapper;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public List<PagoEntity> findAllPago() {
		return pagoMapper.findAllPago();
	}

	@Override
	public Integer insertPago(PagoEntity pago) {
		return pagoMapper.insertPago(pago);
	}

	@Override
	public PagoEntity findByIdPago(Integer idPago) {
		return pagoMapper.findByIdPago(idPago);
	}

	@Override
	@Transactional
	public Boolean generatePago(PaymentDTO pago) {
		
		try {

			UserEntity user = pago.getUser();
			
			List<ServicioEntity> servicios = pago.getServicios();
			
			Integer valorTotal = servicios.stream().mapToInt(i -> i.getPrecio()).sum();
			
			//ir validar 
			
			ContratoEntity contrato = 
					ContratoEntity
					.builder()
					.comentario("PAGO")
					.valor(valorTotal)
					.valorExtra((valorTotal * 0.19))
					.fechaContratacion(formatDate(LocalDateTime.now()))
					.fechaTermino(formatDate(LocalDateTime.now().plusYears(1L)))
					.renovacion("Y")
					.capacitacion("N")
					.representante(RepresentanteEntity.builder().idRepre(2).build())
					.empresa(EmpresaEntity.builder().idEmpresa(1).build())
					.tipoPlan(TipoPlanEntity.builder().idTipoPlan(4).build())
					.estadoContrato(EstadoContratoEntity.builder().idEstadoContrato(1).build())
					.idUser(user.getIdUser())
					.build();
			
			contratoMapper.insertContrato(contrato);
			
			servicios.stream().forEach( s -> {
				detalleContratoMapper.insertDetalleContrato(
						DetalleContratoEntity
						.builder()
						.contrato(contrato)
						.servicio(s)
						.precio(s.getPrecio())
						.build());		
				
			});
			
			pagoMapper.insertPago(PagoEntity.builder()
					.contrato(contrato)
					.Total(valorTotal)
					.user(user)
					.fechaPago(formatDate(LocalDateTime.now()))
					.build());
			log.info("id contrato {} id de Usuario {}",contrato.getIdContrato(),user.getIdUser());
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	
	private String formatDate(LocalDateTime date) {
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(dtformat);
	}
	
	@Scheduled(cron = "${cron.launchtime}")
	public void launcherRenovContratoMensual() {
		
		//Ir a buscar contratos vencidos - No pago este mes
		List<ContratosVencidosDTO> contratosVencidos = pagoMapper.getContratosVencidos();
		
		contratosVencidos.stream().forEach( cv -> {
			//enviar correo de aviso de termino de servicio
			emailService.sendEmailServiceDisable(
					EmailDTO
					.builder()
					.email(cv.getEmail())
					.fechaContratacion(cv.getFechaContratacion())
					.build());
			//actualizar renovacion de contrato a N
			pagoMapper.updateContratos(cv.getIdContrato(),"N");
		});
		
	}

	@Override
	public Boolean generatePagoRev(Integer idContrato, Integer monto, Integer idUser) {
		try {
			pagoMapper.updateContratos(idContrato,"Y");
			pagoMapper.insertPago(
					PagoEntity.builder()
					.contrato(ContratoEntity.builder().idContrato(idContrato).build())
					.Total(monto)
					.user(UserEntity.builder().idUser(idUser).build())
					.fechaPago(formatDate(LocalDateTime.now()))
					.build());
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}

}
