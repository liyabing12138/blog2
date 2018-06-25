package com.blog.wcl.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.consumer.hystrix.TusersServiceFallBack;
import com.blog.wcl.user.entity.Tusers;

@FeignClient(name = "blog-user",fallback=TusersServiceFallBack.class)
public interface TusersServiceInterface {
	
	/**
	 * 获取总记录数
	 */
	@RequestMapping(value = "/user-service/getTotalCount", method = RequestMethod.POST)
	int getTotalCount(Tusers tusers);

	/**
	 * 按实体对象属性动态查找列表
	 */
	@RequestMapping(value="/user-service/findList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Tusers> findList(@RequestBody Tusers tusers);

	/**
	 * 分页
	 */
	@RequestMapping(value="/user-service/findPageList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Pager findPageList(@RequestBody Tusers tusers,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);

	/**
	 * 保存
	 */
	@RequestMapping(value="/user-service/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int save(@RequestBody Tusers tusers);

	/**
	 * 更新
	 */
	@RequestMapping(value="/user-service/update",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int update(@RequestBody Tusers tusers);

	/**
	 * 删除
	 */
	@RequestMapping(value="/user-service/delete",method=RequestMethod.GET)
	int delete(@RequestParam("uid") Integer uid);
	
	
	/**
	 * 按主键查找对象
	 */
	@RequestMapping(value="/user-service/getById",method=RequestMethod.GET)
	Tusers getById(@RequestParam("uid") Integer uid);
	
	/**
	 * 用户登陆
	 */
	@RequestMapping(value="/user-service/login",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Tusers login(@RequestBody Tusers tusers) throws Exception;
}



