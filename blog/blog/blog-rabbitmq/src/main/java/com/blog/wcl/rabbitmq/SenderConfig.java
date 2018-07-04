package com.blog.wcl.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

	@Bean
	public Queue lybqueue(){
		return new Queue("hello-lyb-queue");
	}
}
