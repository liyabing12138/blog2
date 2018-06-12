package com.blog.wcl.article.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tcontents;

/**
 * service基础类
 */
@RequestMapping("/article-service")
public interface TcontentsService<T, PK extends Serializable> {


	/**
	 * 获取总记录数
	 */
	@RequestMapping(value = "/getTotalCount", method = RequestMethod.POST)
	int getTotalCount(Tcontents tcontents);

	/**
	 * 按实体对象属性动态查找列表
	 */
	@RequestMapping(value="findList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	List<T> findList(@RequestBody Tcontents tcontents);

	/**
	 * 分页
	 */
	@RequestMapping(value="findPageList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Pager findPageList(@RequestBody Tcontents tcontents,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);

	/**
	 * 保存
	 */
	@RequestMapping(value="save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int save(@RequestBody Tcontents tcontents);

	/**
	 * 更新
	 */
	@RequestMapping(value="update",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int update(@RequestBody Tcontents tcontents);

	/**
	 * 删除
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	int delete(@RequestParam("cid") Integer cid);
	
	
	/**
	 * 按主键查找对象
	 */
	@RequestMapping(value="getById",method=RequestMethod.GET)
	Tcontents getById(@RequestParam("cid") Integer cid);

}
