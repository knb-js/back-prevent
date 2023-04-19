package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.back.prev.entity.ServicioEntity;
import com.github.pagehelper.Page;

@Mapper
public interface ServicioMapper {
	
	@Select("SELECT ID_SERVICIO     AS idServicio,"
			+ "	NOMBRE_SERVICIO AS nombreServicio,"
			+ "	 ACTIVE,"
			+ "	 IMAGE ,"
			+ "	 DESCRIPCION,"
			+ "	 PRECIO,"
			+ "	 DESCRIPCION_LARGA AS descripcionLarga "
			+ "	FROM SERVICIOS WHERE ACTIVE='Y'")
    List<ServicioEntity> findAll();
	
	@Select({"<script>"+
			"SELECT ID_SERVICIO     AS idServicio,"
			+ "	NOMBRE_SERVICIO AS nombreServicio,"
			+ "	 ACTIVE,"
			+ "	 IMAGE ,"
			+ "	 DESCRIPCION,"
			+ "	 PRECIO,"
			+ "	 DESCRIPCION_LARGA AS descripcionLarga "
			+ "FROM SERVICIOS "
			+ "WHERE 1 = 1 "
			+ "<if test=\"nombre != 'false'\"> and LOWER(NOMBRE_SERVICIO) like CONCAT('%',CONCAT(LOWER(#{nombre}),'%')) </if>"
			+ "<if test=\"descripcion != 'false'\"> and LOWER(DESCRIPCION) like CONCAT('%',CONCAT(LOWER(#{descripcion}),'%')) </if>"
			+ "</script>"})
    Page<ServicioEntity> findAllPage(String nombre,String descripcion);
	
	@Select("SELECT ID_SERVICIO AS idServicio,"
			+ "	NOMBRE_SERVICIO AS nombreServicio,"
			+ "	ACTIVE,"
			+ "	IMAGE ,"
			+ "	DESCRIPCION,"
			+ "	PRECIO,"
			+ "	 DESCRIPCION_LARGA AS descripcionLarga "
			+ "	FROM SERVICIOS WHERE ID_SERVICIO =#{idServicio}"
			+ "AND ACTIVE='Y' ")
    ServicioEntity findById(Integer idServicio);
	
	@Insert("INSERT INTO SERVICIOS(NOMBRE_SERVICIO,ACTIVE,IMAGE,DESCRIPCION,PRECIO,DESCRIPCION_LARGA) " +
            " VALUES (#{nombreServicio}, #{active}, #{image}, #{descripcion}, #{precio}, #{descripcionLarga})")
    Integer insert(ServicioEntity servicio);
	
	@Update("UPDATE SERVICIOS SET NOMBRE_SERVICIO=#{nombreServicio}, ACTIVE=#{active}, IMAGE=#{image}, DESCRIPCION=#{descripcion} ,PRECIO =#{precio}, DESCRIPCION_LARGA=#{descripcionLarga} WHERE ID_SERVICIO=#{idServicio}")
    Integer update(ServicioEntity servicio);
	
	@Delete("DELETE FROM SERVICIOS WHERE ID_SERVICIO = #{idServicio}")
    Integer deleteById(Integer idServicio);
	
	@Update("UPDATE SERVICIOS " + 
			"SET ${field} = #{value} " + 
			"where ID_SERVICIO = #{idService}")
	Integer updateServiceByField(Integer idService, String field, String value);
	
}