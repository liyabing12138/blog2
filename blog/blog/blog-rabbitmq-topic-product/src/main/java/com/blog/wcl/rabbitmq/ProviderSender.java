package com.blog.wcl.rabbitmq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProviderSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	public void send() throws InterruptedException{
		this.rabbitTemplate.convertAndSend(this.exchange,"provider.log.debug","provider.log.debug.....");
		this.rabbitTemplate.convertAndSend(this.exchange,"provider.log.info","provider.log.info.....");
		this.rabbitTemplate.convertAndSend(this.exchange,"provider.log.warn","provider.log.warn.....");
		this.rabbitTemplate.convertAndSend(this.exchange,"provider.log.error","provider.log.error.....");
	}
	
}
