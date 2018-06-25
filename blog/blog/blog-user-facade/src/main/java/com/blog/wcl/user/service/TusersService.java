package com.blog.wcl.user.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.wcl.user.dto.Pager;
import com.blog.wcl.user.entity.Tusers;


/**
 * TusersService接口
 */
@RequestMapping("/user-service")
public interface TusersService <T, PK extends Serializable> {

	/**
	 * 获取总记录数
	 */
	@RequestMapping(value = "/getTotalCount", method = RequestMethod.POST)
	int getTotalCount(Tusers tusers);

	/**
	 * 按实体对象属性动态查找列表
	 */
	@RequestMapping(value="/findList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Tusers> findList(@RequestBody Tusers tusers);

	/**
	 * 分页
	 */
	@RequestMapping(value="/findPageList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Pager findPageList(@RequestBody Tusers tusers,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);

	/**
	 * 保存
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int save(@RequestBody Tusers tusers);

	/**
	 * 更新
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int update(@RequestBody Tusers tusers);

	/**
	 * 删除
	 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	int delete(@RequestParam("uid") Integer uid);
	
	
	/**
	 * 按主键查找对象
	 */
	@RequestMapping(value="/getById",method=RequestMethod.GET)
	Tusers getById(@RequestParam("uid") Integer uid);
	
	
	/**
	 * 用户登陆
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Tusers login(@RequestBody Tusers tusers) throws Exception;
}
