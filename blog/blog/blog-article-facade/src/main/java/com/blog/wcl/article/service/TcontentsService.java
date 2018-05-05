package com.blog.wcl.article.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


}
