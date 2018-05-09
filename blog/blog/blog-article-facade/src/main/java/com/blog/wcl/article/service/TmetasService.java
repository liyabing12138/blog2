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
import com.blog.wcl.article.entity.Tmetas;


/**
 * TmetasService接口
 */
@RequestMapping("/article-tmetas-service")
public interface TmetasService<T, PK extends Serializable>{
	/**
	 * 获取总记录数
	 */
	@RequestMapping(value = "/getTotalCount", method = RequestMethod.POST)
	int getTotalCount(Tmetas tmetas);

	/**
	 * 按实体对象属性动态查找列表
	 */
	@RequestMapping(value="findList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	List<T> findList(@RequestBody Tmetas tmetas);

	/**
	 * 分页
	 */
	@RequestMapping(value="findPageList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Pager findPageList(@RequestBody Tmetas tmetas,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);
}
