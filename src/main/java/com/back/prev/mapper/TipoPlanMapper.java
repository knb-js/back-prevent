package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.back.prev.entity.TipoPlanEntity;

@Mapper
public interface TipoPlanMapper {
	
	@Select("SELECT ID_TIPO_PLAN AS idTipoPlan, "
			+"	NOMBRE_PLAN AS nombrePlan, "
			+"	ACTIVE ,"
			+"	DESCRIPCION"
			+"	FROM TIPO_PLAN WHERE ACTIVE='Y'")
	List<TipoPlanEntity> findAllTipoPlan();
	
	@Select("SELECT ID_TIPO_PLAN AS idTipoPlan,"
			+"	NOMBRE_PLAN AS nombrePlan,"
			+"	ACTIVE ,"
			+"	DESCRIPCION"
			+"	FROM TIPO_PLAN WHERE ID_TIPO_PLAN = #{idTipoPlan}"
			+"	AND ACTIVE='Y' ")
	TipoPlanEntity findByIdTipoPlan(Integer idTipoPlan);
	
	@Insert("INSERT INTO TIPO_PLAN(NOMBRE_PLAN,ACTIVE,DESCRIPCION) " +
			"VALUES (#{nombrePlan}, #{active}, #{descripcion})")
	Integer insertTipoPlan(TipoPlanEntity tipoPlan);
	
	@Update("UPDATE TIPO_PLAN SET NOMBRE_PLAN=#{nombrePlan},ACTIVE=#{active},DESCRIPCION=#{descripcion} WHERE ID_TIPO_PLAN=#{idTipoPlan}")
	Integer updateTipoPlan(TipoPlanEntity tipoPlan);
	
	@Delete("DELETE FROM TIPO_PLAN WHERE ID_TIPO_PLAN = #{idTipoPlan}")
    Integer deleteByIdTipoPlan(Integer idTipoPlan);
		
}