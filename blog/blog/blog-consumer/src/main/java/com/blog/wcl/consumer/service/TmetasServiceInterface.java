package com.blog.wcl.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.blog.wcl.article.service.TmetasService;
@FeignClient(name = "blog-article")
public interface TmetasServiceInterface extends TmetasService{

}
