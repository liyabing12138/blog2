package com.blog.wcl.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
@Service
@EnableBinding({IReceviceService.class})
public  class ReceviceService {

	@StreamListener(IReceviceService.INPUT)
	public void receive(Product ob) throws Exception{
		System.out.println("receive:"+ ob.toString());
	}
	
}
