package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.back.prev.dto.ContratosVencidosDTO;
import com.back.prev.entity.PagoEntity;

@Mapper
public interface PagoMapper {

	@Select("SELECT P.ID_PAGO AS idPago,	"
			+ "       P.TOTAL,	"
			+ "       P.FECHA_PAGO,	"
			+ "       C.ID_CONTRATO AS \"contrato.idContrato\",	"
			+ "       U.ID_USER    AS \"user.idUser\"	"
			+ "FROM PAGO  P	"
			+ "LEFT JOIN CONTRATO C on P.ID_CONTRATO = C.ID_CONTRATO	"
			+ "LEFT JOIN PV_USER U on P.ID_USER = U.ID_USER")
	List<PagoEntity> findAllPago();
	
	@Select("SELECT P.ID_PAGO AS idPago,	"
			+ "       P.TOTAL,	"
			+ "       P.FECHA_PAGO,	"
			+ "       C.ID_CONTRATO AS \"contrato.idContrato\",	"
			+ "       U.ID_USER    AS \"user.idUser\"	"
			+ "FROM PAGO  P	"
			+ "LEFT JOIN CONTRATO C on P.ID_CONTRATO = C.ID_CONTRATO	"
			+ "LEFT JOIN PV_USER U on P.ID_USER = U.ID_USER	"
			+ "WHERE ID_PAGO =#{idPago}")
	PagoEntity findByIdPago(Integer idPago);
	
	@Insert("INSERT INTO PAGO (ID_CONTRATO, TOTAL, ID_USER, FECHA_PAGO)	"
			+ "    VALUES (#{contrato.idContrato}, #{total}, #{user.idUser}, #{fechaPago})")
    Integer insertPago(PagoEntity pago);
	
	@Select("SELECT distinct P.ID_CONTRATO as idContrato, PU.EMAIL, C.FECHA_CONTRATACION as fechaContratacion "
			+ "FROM PAGO P "
			+ "         JOIN CONTRATO C on P.ID_CONTRATO = C.ID_CONTRATO "
			+ "         JOIN PV_USER PU on C.ID_USER = PU.ID_USER "
			+ "WHERE TO_CHAR(SYSDATE, 'YYYY-MM') <> TO_CHAR(P.FECHA_PAGO, 'YYYY-MM') "
			+ "  and 0 = (select count(p.ID_PAGO) "
			+ "           from pago p "
			+ "           where ID_CONTRATO = C.ID_CONTRATO "
			+ "             and TO_CHAR(FECHA_PAGO, 'YYYY-MM') = TO_CHAR(SYSDATE, 'YYYY-MM')) "
			+ "  AND TO_CHAR(C.FECHA_CONTRATACION, 'DD') = TO_CHAR(SYSDATE, 'DD') "
			+ "  AND SYSDATE BETWEEN FECHA_CONTRATACION AND FECHA_TERMINO "
			+ "  and C.RENOVACION = 'Y' ")
	List<ContratosVencidosDTO> getContratosVencidos();
	
	@Update("UPDATE CONTRATO SET RENOVACION = #{renovacion} WHERE ID_CONTRATO = #{idContrato}")
    Integer updateContratos(Integer idContrato,String renovacion);
		
}
