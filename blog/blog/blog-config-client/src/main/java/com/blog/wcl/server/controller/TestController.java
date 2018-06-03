package com.blog.wcl.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 阿甘 http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@RestController
@RefreshScope
public class TestController {

	@Value("${version}")
	private String msg;
	
	@RequestMapping("/test")
	public String test(){
		return this.msg;
	}
}
