package com.blog.wcl.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings=@QueueBinding(
		value= @Queue(value="${mq.config.queue.info}",autoDelete="true"),
		exchange=@Exchange(value="${mq.config.exchange}",type=ExchangeTypes.DIRECT),
		key="${mq.config.queue.info.routing.key}"
		)
		)
public  class InfoReceiver {

	@RabbitHandler
	public void process(String msg){
		 System.out.println("接收到的INFO日志:"+msg);
	}
	
}
