package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.back.prev.entity.ContratoEntity;
import com.github.pagehelper.Page;

@Mapper
public interface ContratoMapper {
	
	@Select("SELECT  CC.ID_CONTRATO AS idContrato,	"
			+ "        CC.COMENTARIO,	"
			+ "        CC.VALOR,	"
			+ "        CC.VALOR_EXTRA	AS	valorExtra	,	"
			+ "        CC.FECHA_CONTRATACION	AS fechaContratacion	,	"
			+ "        CC.FECHA_TERMINO	AS	fechaTermino	,	"
			+ "        CC.RENOVACION,	"
			+ "        CC.CAPACITACION,	"
			+ "        RR.ID_REPRE AS \"representante.idRepre\"	,	"
			+ "        EE.ID_EMPRESA AS \"empresa.idEmpresa\"	,	"
			+ "        TP.ID_TIPO_PLAN AS \"tipoPlan.idTipoPlan\"	,	"
			+ "        EC.ID_ESTADOCONTRA	AS \"estadoContrato.idEstadoContrato\"	"
			+ "        FROM CONTRATO CC	"
			+ "        LEFT JOIN REPRESENTANTE RR on CC.REPRESENTANTE_ID_REPRE = RR.ID_REPRE	"
			+ "        LEFT JOIN EMPRESA EE on CC.EMPRESA_ID_EMPRESA = EE.ID_EMPRESA	"
			+ "        LEFT JOIN TIPO_PLAN TP on CC.TIPO_PLAN_ID_TIPO_PLAN = TP.ID_TIPO_PLAN	"
			+ "        LEFT JOIN ESTADO_CONTRATO EC on CC.ESTADO_CONTRATO_ID = EC.ID_ESTADOCONTRA")
	List<ContratoEntity> findAllContrato();
	
	
	@Insert("INSERT INTO CONTRATO (COMENTARIO,VALOR,VALOR_EXTRA,FECHA_CONTRATACION,FECHA_TERMINO,RENOVACION,CAPACITACION,REPRESENTANTE_ID_REPRE,EMPRESA_ID_EMPRESA,TIPO_PLAN_ID_TIPO_PLAN,ESTADO_CONTRATO_ID,ID_USER)	"
			+ "    VALUES (#{comentario}, #{valor}, #{valorExtra}, #{fechaContratacion}, #{fechaTermino}, #{renovacion}, #{capacitacion}, #{representante.idRepre}, #{empresa.idEmpresa}, #{tipoPlan.idTipoPlan}, #{estadoContrato.idEstadoContrato},#{idUser})")
	@Options(useGeneratedKeys = true, keyProperty = "idContrato", keyColumn = "ID_CONTRATO")
	Integer insertContrato (ContratoEntity contrato);
	
	@Select({"<script>"+
			"SELECT  CC.ID_CONTRATO AS idContrato,	"
			+ "        CC.COMENTARIO,	"
			+ "        CC.VALOR,	"
			+ "        CC.VALOR_EXTRA	AS	valorExtra	,	"
			+ "        CC.FECHA_CONTRATACION	AS fechaContratacion	,	"
			+ "        CC.FECHA_TERMINO	AS	fechaTermino	,	"
			+ "        CC.RENOVACION,	"
			+ "        CC.CAPACITACION,	"
			+ "        CC.ID_USER AS \"representante.idRepre\"	,	"
			+ "        CONCAT(CONCAT(NAME,' '),LAST_NAME) AS \"representante.nombreRepre\"	,	"
			+ "        EE.ID_EMPRESA AS \"empresa.idEmpresa\"	,	"
			+ "        EE.NOMBRE_EMPR AS \"empresa.nombreEmpresa\"	,	"
			+ "        TP.ID_TIPO_PLAN AS \"tipoPlan.idTipoPlan\"	,	"
			+ "        TP.NOMBRE_PLAN AS \"tipoPlan.nombrePlan\"	,	"
			+ "        EC.ID_ESTADOCONTRA	AS \"estadoContrato.idEstadoContrato\",	"
			+ "        EC.DESCRIPCION	AS \"estadoContrato.descripcion\"	"
			+ "        FROM CONTRATO CC	"
			+ "        LEFT JOIN PV_USER RR on CC.ID_USER = RR.ID_USER	"
			+ "        LEFT JOIN EMPRESA EE on CC.EMPRESA_ID_EMPRESA = EE.ID_EMPRESA	"
			+ "        LEFT JOIN TIPO_PLAN TP on CC.TIPO_PLAN_ID_TIPO_PLAN = TP.ID_TIPO_PLAN	"
			+ "        LEFT JOIN ESTADO_CONTRATO EC on CC.ESTADO_CONTRATO_ID = EC.ID_ESTADOCONTRA"
			+ "	WHERE 1 = 1 "
			+ " and CC.ID_USER = #{idUser}"
			+ "<if test=\"fechaContratacion != 'false'\"> and to_char(FECHA_CONTRATACION,'YYYY-MM-DD') = #{fechaContratacion} </if>"
			+ "<if test=\"fechaTermino != 'false'\"> and to_char(FECHA_TERMINO,'YYYY-MM-DD') = #{fechaTermino} </if>"
			+ "</script>"
			})
    Page<ContratoEntity> findAllPageContrato(String fechaContratacion, String fechaTermino, String idUser);
	
	@Update("UPDATE CONTRATO " + 
			"SET ${field} = #{value} " + 
			"where ID_CONTRATO = #{idContrato}")
	Integer updateContratoByField(Integer idContrato, String field, String value);
}
