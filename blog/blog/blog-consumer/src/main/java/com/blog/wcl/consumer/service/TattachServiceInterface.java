package com.blog.wcl.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.wcl.consumer.hystrix.TattachServiceFallbcak;
import com.blog.wcl.user.dto.Pager;
import com.blog.wcl.user.entity.Tattach;
import com.blog.wcl.user.entity.Tcomments;

@FeignClient(name = "blog-user",fallback=TattachServiceFallbcak.class)
public interface TattachServiceInterface {
	/**
	 * 获取总记录数
	 */
	@RequestMapping(value = "/tattach-service/getTotalCount", method = RequestMethod.POST)
	int getTotalCount(Tattach tattach);

	/**
	 * 按实体对象属性动态查找列表
	 */
	@RequestMapping(value="/tattach-service/findList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Tattach> findList(@RequestBody Tattach tattach);
	/**
	 * 根据条件查询总数
	 * @param tattach
	 * @return
	 */
	@RequestMapping(value="/tattach-service/getCountSize",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int getCountSize(@RequestBody Tattach tattach);
	
	/**
	 * 分页
	 */
	@RequestMapping(value="/tattach-service/findPageList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Pager findPageList(@RequestBody Tattach tattach,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);

	/**
	 * 保存
	 */
	@RequestMapping(value="/tattach-service/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int save(@RequestBody Tattach tattach);

	/**
	 * 更新
	 */
	@RequestMapping(value="/tattach-service/update",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int update(@RequestBody Tattach tattach);

	/**
	 * 删除
	 */
	@RequestMapping(value="/tattach-service/delete",method=RequestMethod.GET)
	int delete(@RequestParam("id") Integer id);
	
	
	/**
	 * 按主键查找对象
	 */
	@RequestMapping(value="/tattach-service/getById",method=RequestMethod.GET)
	Tattach getById(@RequestParam("id") Integer id);
}
