package com.ground.web.javamail.configuration;

import java.util.Map;

import org.springframework.mail.SimpleMailMessage;

public interface Sender {
	public void send(final SimpleMailMessage msg,  final Map<String, Object> hTemplateVariables);
}
