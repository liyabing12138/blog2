package com.blog.wcl.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.article.service.TcontentsService;
import com.blog.wcl.consumer.hystrix.TcontentsServiceFallBack;

//
@FeignClient(name = "blog-article",fallback=TcontentsServiceFallBack.class)
public interface TcontentsServiceInterface {
	
	/**
	 * 获取总记录数
	 */
	@RequestMapping(value = "/article-service/getTotalCount", method = RequestMethod.POST)
	int getTotalCount(Tcontents tcontents);

	/**
	 * 按实体对象属性动态查找列表
	 */
	@RequestMapping(value="/article-service/findList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Tcontents> findList(@RequestBody Tcontents tcontents);

	/**
	 * 分页
	 */
	@RequestMapping(value="/article-service/findPageList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Pager findPageList(@RequestBody Tcontents tcontents,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);

	/**
	 * 保存
	 */
	@RequestMapping(value="/article-service/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int save(@RequestBody Tcontents tcontents);

	/**
	 * 更新
	 */
	@RequestMapping(value="/article-service/update",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int update(@RequestBody Tcontents tcontents);

	/**
	 * 删除
	 */
	@RequestMapping(value="/article-service/delete",method=RequestMethod.GET)
	int delete(@RequestParam("cid") Integer cid);
	
	
	/**
	 * 按主键查找对象
	 */
	@RequestMapping(value="/article-service/getById",method=RequestMethod.GET)
	Tcontents getById(@RequestParam("cid") Integer cid);
	
	
}



