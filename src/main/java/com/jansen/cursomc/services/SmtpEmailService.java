package com.jansen.cursomc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;
	
//	@Autowired
//	private JavaMailSender javaMailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Enviando Email...");
		mailSender.send(msg);
		LOG.info("Email Enviado");
		
	}

//	@Override
//	public void sendHtmlEmail(MimeMessage msg) {
//		LOG.info("Enviando Email...");
//		javaMailSender.send(msg);
//		LOG.info("Email Enviado");
//		
//	}
}
