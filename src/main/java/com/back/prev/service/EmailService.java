package com.back.prev.service;

import com.back.prev.dto.EmailDTO;

public interface EmailService {
	
	void sendEmailPassword(EmailDTO email);
	
	void sendEmailResetPassword(EmailDTO email);
	
	void sendEmailServiceDisable(EmailDTO email);

}
