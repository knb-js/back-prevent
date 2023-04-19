package com.back.prev.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.back.prev.config.ConfigValues;
import com.back.prev.dto.EmailDTO;
import com.back.prev.service.EmailService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
@EnableAsync
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private ConfigValues configValues;
	
	@Autowired
	private Configuration config;

	@Override
	public void sendEmailPassword(EmailDTO email) {
		genericSendMail(email, "email-template.ftl", "Verificación de cuenta ✅", configValues.getUrlFront());
	}

	@Override
	public void sendEmailResetPassword(EmailDTO email) {
		genericSendMail(email, "email-resetpwd.ftl", "Solicitud para cambio de contraseña", configValues.getUrlFrontResetPassword());
	}
	
	@Override
	public void sendEmailServiceDisable(EmailDTO email) {
		genericSendMail(email, "email-servicios-apagados.ftl", "Sus servicios van a ser desactivados ❌", "");
	}
	
	private void genericSendMail(EmailDTO email,String templateRoute,String subject,String url) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		Template template = null;
		String html = "";
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());
			try {
				template = config.getTemplate(templateRoute);
			} catch (IOException e) {
				e.printStackTrace();
			}
			email.setUrlToken(url+email.getUrlToken());
			
			html = FreeMarkerTemplateUtils.processTemplateIntoString(template, email);
			helper.setFrom(configValues.getFromEmail());
			helper.setTo(email.getEmail());
			helper.setText(html,true);
			helper.setSubject(subject);
			mailSender.send(mimeMessage);
		} catch (MessagingException | IOException | TemplateException e) {
			e.printStackTrace();
		}
	}



}
