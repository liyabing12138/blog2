package com.blog.wcl.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tmetas;
import com.blog.wcl.consumer.hystrix.TmetasServiceFallBack;
@FeignClient(name = "blog-article",fallback=TmetasServiceFallBack.class)
public interface TmetasServiceInterface {

	/**
	 * 获取总记录数
	 */
	@RequestMapping(value = "/article-tmetas-service/getTotalCount", method = RequestMethod.POST)
	int getTotalCount(Tmetas tmetas);

	/**
	 * 按实体对象属性动态查找列表
	 */
	@RequestMapping(value="/article-tmetas-service/findList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Tmetas> findList(@RequestBody Tmetas tmetas);

	/**
	 * 分页
	 */
	@RequestMapping(value="/article-tmetas-service/findPageList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Pager findPageList(@RequestBody Tmetas tmetas,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);
	
	/**
	 * 保存
	 */
	@RequestMapping(value="/article-tmetas-service/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int saveTmetas(@RequestBody Tmetas tmetas);

	/**
	 * 更新
	 */
	@RequestMapping(value="/article-tmetas-service/update",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int update(@RequestBody Tmetas tmetas);

	/**
	 * 删除
	 */
	@RequestMapping(value="/article-tmetas-service/delete",method=RequestMethod.GET)
	int delete(@RequestParam("cid") Integer cid);
	
	
	/**
	 * 按主键查找对象
	 */
	@RequestMapping(value="/article-tmetas-service/getById",method=RequestMethod.GET)
	Tmetas getById(@RequestParam("cid") Integer cid);
	
}
