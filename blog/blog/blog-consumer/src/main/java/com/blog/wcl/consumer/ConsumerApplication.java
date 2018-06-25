package com.blog.wcl.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import feign.Logger;


/**
 * @author wcl http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class ConsumerApplication {
	
	@Bean
	public Logger.Level feignLoggerLevel(){
//		NONE, 不记录任何信息，默认值。
//		BASIC, 记录请求方法、请求URL、状态码和用时。
//		HEADERS, 在BASIC的基础上再记录一些常用信息。
//		FULL: 记录请求和响应报文的全部内容。
		return Logger.Level.FULL;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
