package com.blog.wcl.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wcl http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication()
@MapperScan("com.blog.wcl.user.mapper")
public class UsesrApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsesrApplication.class, args);
	}
}
