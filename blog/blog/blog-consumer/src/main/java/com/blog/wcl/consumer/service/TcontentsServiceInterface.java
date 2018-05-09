package com.blog.wcl.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import com.blog.wcl.article.service.TcontentsService;


@FeignClient(name = "blog-article")
public interface TcontentsServiceInterface extends TcontentsService{
	 
}



