package com.blog.wcl.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public  interface IReceviceService {
	
	String INPUT="inputProduct";

	@Input(INPUT)
	SubscribableChannel receive();
}
