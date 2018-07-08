package com.blog.wcl.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({ISendService.class})
public class StreamSenderApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StreamSenderApplication.class, args);
	}
}
