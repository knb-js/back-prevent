package com.back.prev.service.impl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.prev.config.CustomPasswordEncoder;
import com.back.prev.dto.EmailDTO;
import com.back.prev.entity.UserEntity;
import com.back.prev.mapper.UserMapper;
import com.back.prev.service.EmailService;
import com.back.prev.service.UserService;
import com.github.pagehelper.Page;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {
	
	@Autowired
	CustomPasswordEncoder customPasswdEncoder;
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private EmailService emailService;
	
	@Override
	public UserEntity loginUser(UserEntity user) {
		return userMapper.getUserLogin(user.getLogin());
	}
	
	@Override
	public Page<UserEntity> findAllPage(String rut, String name, String lastName, String id_profile, String email) {
		return userMapper.findAllPage(rut, name, lastName, id_profile, email);
	}

	@Override
	public String getEmailUser(Integer idUser) {
		return userMapper.getEmailById(idUser);
	}

	@Override
	public Integer updateVerified(Integer idUser) {
		return userMapper.updateVerified(idUser);
	}
	
	@Override
	public void sendMailByEmail(EmailDTO email) {
		if (userMapper.validateUserByEmail(email.getEmail()) > 0) {
			emailService.sendEmailResetPassword(email);
		}
	}

	@Override
	public Integer updatePassword(UserEntity user) {
		return userMapper.updatePässword(user.getEmail(), customPasswdEncoder.encode(user.getPasswd()));
	}

	@Override
	public Integer registerUser(UserEntity user) {
		try {
			user.setPasswd(customPasswdEncoder.encode(user.getPasswd()));
			user.setUsername(user.getName().substring(0,1)+"." + user.getLastName()+user.getRut());
			return userMapper.registerUser(user);
		} catch (Exception e) {
			log.info("Ha ocurrido un error al registrar {} ",e.getMessage());
			return 0;
		}

	}

	@Override
	public Integer updateUserByField(Integer idUser, String field, String value) {
		return userMapper.updateUserByField(idUser, field, field.equals("image") ? decode(value) : value);
	}
	
	public String decode(String text) {
		return new String(Base64.getDecoder().decode(text));
	}

}
