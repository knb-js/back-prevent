package com.back.prev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.prev.mapper.UserMapper;

@RestController
@RequestMapping("/health")
public class HealthController {
	
	@Autowired
	private UserMapper userMapper;
	
//	@Autowired
//	private PrevUtil prevUtil;
	
	@GetMapping("/{login}")
	public ResponseEntity<?> echoTest(@PathVariable("login") String login) {
//		ResponseApi out = new ResponseApi();
//		out = new ResponseApi("Service ON", 200, true, null);
		return new ResponseEntity<Object>(userMapper.getUserLogin(login), HttpStatus.OK);
	}
	
//	public static void main(String[] args) {
//		System.out.println(encode("test"));
//	}
//	//098f6bcd4621d373cade4e832627b4f6
//
//	public static String encode(CharSequence input) {
//		return getMD5(input);
//	}
//
//	private static String getMD5(CharSequence input) {
//		try {
//			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
//			byte[] messageDigest = md.digest(((String) input).getBytes());
//			java.math.BigInteger number = new java.math.BigInteger(1, messageDigest);
//			String hashtext = number.toString(16);
//
//			while (hashtext.length() < 32) {
//				hashtext = "0" + hashtext;
//			}
//			return hashtext;
//		} catch (java.security.NoSuchAlgorithmException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
}
