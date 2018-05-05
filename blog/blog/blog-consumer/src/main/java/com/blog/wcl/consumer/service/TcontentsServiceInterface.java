package com.blog.wcl.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.wcl.article.service.TcontentsService;


@FeignClient(name = "blog-article")
public interface TcontentsServiceInterface extends TcontentsService{
	 
}



