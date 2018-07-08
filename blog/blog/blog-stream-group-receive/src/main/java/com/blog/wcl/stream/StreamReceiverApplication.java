package com.blog.wcl.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({IReceviceService.class})
public class StreamReceiverApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StreamReceiverApplication.class, args);
	}
}
