package com.blog.wcl.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * @author wcl
 * @see http://study.163.com/provider/1016671292/index.htm
 * @version 1.0
 */
@Component
@RabbitListener(bindings=@QueueBinding(
		value= @Queue(value="${mq.config.queue.sms}",autoDelete="true"),
		exchange=@Exchange(value="${mq.config.exchange}",type=ExchangeTypes.FANOUT)
		)
		)
public class SmsReceiver {
	
	@RabbitHandler
	public void process(String msg){
		System.out.println("短信发送---------------日志:"+msg);
	}
}
