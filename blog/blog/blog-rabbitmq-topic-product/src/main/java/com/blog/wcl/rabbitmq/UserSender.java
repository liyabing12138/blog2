package com.blog.wcl.rabbitmq;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	public void send() throws InterruptedException{
		this.rabbitTemplate.convertAndSend(this.exchange,"user.log.debug","user.log.debug.....");
		this.rabbitTemplate.convertAndSend(this.exchange,"user.log.info","user.log.info.....");
		this.rabbitTemplate.convertAndSend(this.exchange,"user.log.warn","user.log.warn.....");
		this.rabbitTemplate.convertAndSend(this.exchange,"user.log.error","user.log.error.....");
	}
	
}
