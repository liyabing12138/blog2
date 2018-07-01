package com.blog.wcl.user.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.blog.wcl.user.dto.Pager;
import com.blog.wcl.user.entity.Tattach;
/**
 * TattachService接口
 */
@RequestMapping("/tattach-service")
public interface TattachService<T, PK extends Serializable> {

	/**
	 * 获取总记录数
	 */
	@RequestMapping(value = "/getTotalCount", method = RequestMethod.POST)
	int getTotalCount(Tattach tattach);

	/**
	 * 按实体对象属性动态查找列表
	 */
	@RequestMapping(value="/findList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Tattach> findList(@RequestBody Tattach tattach);
	
	/**
	 * 根据条件查询总数
	 * @param tattach
	 * @return
	 */
	@RequestMapping(value="/getCountSize",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int getCountSize(@RequestBody Tattach tattach);

	/**
	 * 分页
	 */
	@RequestMapping(value="/findPageList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Pager findPageList(@RequestBody Tattach tattach,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);

	/**
	 * 保存
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int save(@RequestBody Tattach tattach);

	/**
	 * 更新
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int update(@RequestBody Tattach tattach);

	/**
	 * 删除
	 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	int delete(@RequestParam("id") Integer id);
	
	
	/**
	 * 按主键查找对象
	 */
	@RequestMapping(value="/getById",method=RequestMethod.GET)
	Tattach getById(@RequestParam("id") Integer id);
	
	
}
