package com.jansen.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.jansen.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

//	void sendOrderConfirmationHtmlEmail(Pedido obj);
//
//	void sendHtmlEmail(MimeMessage msg);

//	void sendNewPasswordEmail(Cliente cliente, String msg);
}
