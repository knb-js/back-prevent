package com.back.prev.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.back.prev.entity.UserEntity;
import com.github.pagehelper.Page;

@Mapper
public interface UserMapper {

	@Select("SELECT US.ID_USER AS idUser, "
			+ "			        US.username,   "
			+ "			        US.rut,   "
			+ "			        US.dv,   "
			+ "			        US.name,   "
			+ "			        US.last_name as lastName,   "
			+ "			        US.address,     "
			+ "			        US.email,   "
			+ "			        US.image,   "
			+ "			        US.password as passwd,   "
			+ "			        US.last_connection as lastConnection,   "
			+ "			 		US.first_session as firstSession, "
			+ "			        US.verified,   "
			+ "			 		US.birthday,   "
			+ "			 		US.contact_Phone AS contactPhone, "
			+ "			 		US.CORPORATE_EMAIL AS corporateEmail, "
			+ "			        PP.id_profile as   \"profile.idProfile\"  , "
			+ "			        pp.CODE as   \"profile.code\"  , "
			+ "			        PP.NAME as  \"profile.name\", "
			+ "			 		NN.ID_NACIO as  \"nacionalidad.idNacionalidad\"  , "
			+ "			 		NN.DESCRIPCION as  \"nacionalidad.descripcion\"  , "
			+ "			 		GG.ID_GENERO as  \"genero.idGenero\"  , "
			+ "			 		GG.DESCRIPCION as  \"genero.descripcion\"  , "
			+ "			 		CC.ID_COMUNA as  \"comuna.idComuna\"  , "
			+ "			 		CC.DESCRIPCION as  \"comuna.descripcion\"  , "
			+ "			 		EC.ID_ESTADOCIVIL as  \"estadoCivil.idEstadoCivil\"  , "
			+ "			 		EC.DESCRIPCION as  \"estadoCivil.descripcion\" "
			+ "FROM PV_USER US "
			+ "    LEFT JOIN PROFILE PP on US.ID_PROFILE 			= PP.ID_PROFILE "
			+ "    LEFT JOIN NACIONALIDAD NN "
			+ "on US.NACIONALIDAD_ID_NACIO = NN.ID_NACIO "
			+ "    LEFT JOIN GENERO GG on US.GENERO_ID_GENERO = GG.ID_GENERO "
			+ "    LEFT JOIN COMUNA CC on US.COMUNA_ID_COMUNA = CC.ID_COMUNA "
			+ "    LEFT JOIN ESTADO_CIVIL EC on US.ESTADO_CIVIL_ID_ESTADOCIVIL = EC.ID_ESTADOCIVIL "
			+ "WHERE TO_CHAR(US.RUT) = #{login} "
			+ "   OR US.USERNAME = #{login} "
			+ "   OR US.EMAIL = #{login} "
			+ "  and us.ACTIVE = 'Y' and PP.ACTIVE = 'Y' ")
	UserEntity getUserLogin(String login);
	
	@Select({"<script>"+
			"SELECT US.ID_USER AS idUser, "
			+ "			        US.username,   "
			+ "			        US.rut,   "
			+ "			        US.dv,   "
			+ "			        US.name,   "
			+ "			        US.last_name as lastName,   "
			+ "			        US.address,     "
			+ "			        US.email,   "
			+ "			        US.image,   "
			+ "			        US.password as passwd,   "
			+ "			        US.last_connection as lastConnection,   "
			+ "			 		US.first_session as firstSession, "
			+ "			        US.verified,   "
			+ "			 		US.birthday,   "
			+ "			 		US.contact_Phone AS contactPhone, "
			+ "			 		US.CORPORATE_EMAIL AS corporateEmail, "
			+ "			        PP.id_profile as   \"profile.idProfile\"  , "
			+ "			        pp.CODE as   \"profile.code\"  , "
			+ "			        PP.NAME as  \"profile.name\", "
			+ "			 		NN.ID_NACIO as  \"nacionalidad.idNacionalidad\"  , "
			+ "			 		NN.DESCRIPCION as  \"nacionalidad.descripcion\"  , "
			+ "			 		GG.ID_GENERO as  \"genero.idGenero\"  , "
			+ "			 		GG.DESCRIPCION as  \"genero.descripcion\"  , "
			+ "			 		CC.ID_COMUNA as  \"comuna.idComuna\"  , "
			+ "			 		CC.DESCRIPCION as  \"comuna.descripcion\"  , "
			+ "			 		EC.ID_ESTADOCIVIL as  \"estadoCivil.idEstadoCivil\"  , "
			+ "			 		EC.DESCRIPCION as  \"estadoCivil.descripcion\", "
			+ "			 		US.ACTIVE "
			+ "FROM PV_USER US "
			+ "    LEFT JOIN PROFILE PP on US.ID_PROFILE 			= PP.ID_PROFILE "
			+ "    LEFT JOIN NACIONALIDAD NN "
			+ "on US.NACIONALIDAD_ID_NACIO = NN.ID_NACIO "
			+ "    LEFT JOIN GENERO GG on US.GENERO_ID_GENERO = GG.ID_GENERO "
			+ "    LEFT JOIN COMUNA CC on US.COMUNA_ID_COMUNA = CC.ID_COMUNA "
			+ "    LEFT JOIN ESTADO_CIVIL EC on US.ESTADO_CIVIL_ID_ESTADOCIVIL = EC.ID_ESTADOCIVIL "
			+ "WHERE 1 = 1 "
			+ "<if test=\"name != 'false'\"> and LOWER(US.NAME) like CONCAT('%',CONCAT(LOWER(#{name}),'%')) </if>"
			+ "<if test=\"lastName != 'false'\"> and LOWER(US.LAST_NAME) like CONCAT('%',CONCAT(LOWER(#{lastName}),'%')) </if>"
			+ "<if test=\"email != 'false'\"> and LOWER(US.EMAIL) like CONCAT('%',CONCAT(LOWER(#{email}),'%')) </if>"
			+ "<if test=\"rut != 'false'\"> and US.RUT like CONCAT('%',CONCAT(#{rut},'%')) </if>"
			+ "<if test=\"id_profile != 'false'\"> and US.id_profile = #{id_profile} </if>"
			+ "</script>"})
	Page<UserEntity> findAllPage(String rut, String name, String lastName,String id_profile, String email);
	
	@Select("select email from PV_USER where ID_USER = #{idUser}")
	String getEmailById(Integer idUser);
	
	@Update("update PV_USER set VERIFIED = 'Y' where ID_USER = #{idUser}")
	Integer updateVerified(Integer idUser);
	
	@Select("SELECT COUNT(*) FROM PV_USER WHERE email = #{email}")
	Integer validateUserByEmail(String email);
	
	@Update("update PV_USER set password = #{password} where email = #{email}")
	Integer updatePässword(String email,String password);
	
	/*
	@Insert("insert into PV_USER (USERNAME,RUT,DV,NAME,lAST_NAME,ADDRESS,EMAIL,PASSWORD,BIRTHDAY,CONTACT_PHONE,CORPORATE_EMAIL,ID_PROFILE) "+
			"values (#{username},#{rut},#{dv},#{name},#{lastName},#{address},#{email},#{passwd},#{birthday},#{contactPhone},#{corporateEmail},2)")
	Integer registerUser(UserEntity user);
	*/										
																			            
	@Insert("INSERT INTO PV_USER(RUT, NAME, LAST_NAME, ADDRESS, BIRTHDAY, NACIONALIDAD_ID_NACIO, GENERO_ID_GENERO, COMUNA_ID_COMUNA, ID_PROFILE,CONTACT_PHONE, " +
            	"EMAIL, ESTADO_CIVIL_ID_ESTADOCIVIL, CORPORATE_EMAIL,DV ,USERNAME ,PASSWORD ,ACTIVE,VERIFIED, CREATED,UPDATED)"+
            	"VALUES (#{rut} ,#{name} , #{lastName}, #{address}, #{birthday}, #{nacionalidad.idNacionalidad}, #{genero.idGenero}, #{comuna.idComuna},2 , #{contactPhone}, #{email}, "
            	+ "#{estadoCivil.idEstadoCivil},#{corporateEmail},#{dv},#{username},#{passwd},'Y','N',SYSDATE,SYSDATE )")
    Integer registerUser(UserEntity user);
	
	@Update("UPDATE PV_USER " + 
			"SET ${field} = #{value} " + 
			"where ID_USER = #{idUser}")
	Integer updateUserByField(Integer idUser, String field, String value);
            	
}



