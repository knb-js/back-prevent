package com.back.prev.service;

import com.back.prev.dto.EmailDTO;
import com.back.prev.entity.UserEntity;
import com.github.pagehelper.Page;

public interface UserService {
	
	UserEntity loginUser(UserEntity user);
	
	Page<UserEntity> findAllPage(String rut, String name, String lastName,String id_profile, String email);

	String getEmailUser(Integer idUser);
	
	Integer updateVerified(Integer idUser);

	void sendMailByEmail(EmailDTO email);
	
	Integer updatePassword(UserEntity user);
	
	Integer registerUser(UserEntity user);
	
	Integer updateUserByField(Integer idUser, String field, String value);
	
}
