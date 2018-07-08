package com.blog.wcl.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamSenderApplication.class)
public class StreamApplicationTests {
	
	@Autowired
	private ISendService sendService;
	
	@Test
	public void send() throws InterruptedException {
		Product obj=new Product();
		obj.setId(100);
		obj.setName("spring cloud课件资料");
		Message message = MessageBuilder.withPayload(obj).build();
	    this.sendService.send().send(message);
	}

}
