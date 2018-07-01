package com.blog.wcl.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.wcl.consumer.hystrix.TcommentsServiceFallbcak;
import com.blog.wcl.user.dto.Pager;
import com.blog.wcl.user.entity.Tcomments;

@FeignClient(name = "blog-user",fallback=TcommentsServiceFallbcak.class)
public interface TcommentsServiceInterface {
	/**
	 * 获取总记录数
	 */
	@RequestMapping(value = "/tcomments-service/getTotalCount", method = RequestMethod.POST)
	int getTotalCount(Tcomments tcomments);

	/**
	 * 按实体对象属性动态查找列表
	 */
	@RequestMapping(value="/tcomments-service/findList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Tcomments> findList(@RequestBody Tcomments tcomments);

	/**
	 * 查询最新的评论
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/tcomments-service/findRecentComment",method=RequestMethod.GET)
	List<Tcomments> findRecentComment(@RequestParam("pageSize") Integer pageSize);
	
	/**
	 * 根据条件查询总数
	 * @param tattach
	 * @return
	 */
	@RequestMapping(value="/tcomments-service/getCountSize",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int getCountSize(@RequestBody Tcomments tcomments);
	
	/**
	 * 分页
	 */
	@RequestMapping(value="/tcomments-service/findPageList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Pager findPageList(@RequestBody Tcomments tcomments,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);

	/**
	 * 保存
	 */
	@RequestMapping(value="/tcomments-service/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int save(@RequestBody Tcomments tcomments);

	/**
	 * 更新
	 */
	@RequestMapping(value="/tcomments-service/update",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int update(@RequestBody Tcomments tcomments);

	/**
	 * 删除
	 */
	@RequestMapping(value="/tcomments-service/delete",method=RequestMethod.GET)
	int delete(@RequestParam("coid") Integer coid);
	
	
	/**
	 * 按主键查找对象
	 */
	@RequestMapping(value="/tcomments-service/getById",method=RequestMethod.GET)
	Tcomments getById(@RequestParam("coid") Integer coid);
}
