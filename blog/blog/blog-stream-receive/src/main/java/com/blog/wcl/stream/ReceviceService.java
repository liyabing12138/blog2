package com.blog.wcl.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
@Service
@EnableBinding({IReceviceService.class})
public  class ReceviceService {

	@StreamListener("lyb-hist")
	public void receive(byte[] msg) throws Exception{
		System.out.println("receive:"+ new String(msg));
	}
	
}
