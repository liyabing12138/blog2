package com.blog.wcl.article.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tmetas;
import com.blog.wcl.article.entity.Trelationships;
@RequestMapping("/article-trelationships-service")
public interface TrelationshipsService <T, PK extends Serializable>{

	/**
	 * 获取总记录数
	 */
	@RequestMapping(value = "/getTotalCount", method = RequestMethod.POST)
	int getTotalCount(Trelationships trelationships);

	/**
	 * 按实体对象属性动态查找列表
	 */
	@RequestMapping(value="/findList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Trelationships> findList(@RequestBody Trelationships trelationships);

	/**
	 * 分页
	 */
	@RequestMapping(value="/findPageList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	Pager findPageList(@RequestBody Trelationships trelationships,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);
	
	/**
	 * 保存
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int save(@RequestBody Trelationships trelationships);

	/**
	 * 更新
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	int update(@RequestBody Trelationships trelationships);

	/**
	 * 删除
	 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	int delete(@RequestParam("cid") Integer cid,@RequestParam("mid") Integer mid);
	
	
	/**
	 * 按主键查找对象
	 */
	@RequestMapping(value="/getById",method=RequestMethod.GET)
	Trelationships getById(@RequestParam("cid") Integer cid,@RequestParam("mid") Integer mid);
	
	/**
	 * 只是根据CID删除
	 * @param pk
	 * @return
	 */
	@RequestMapping(value="/deleteByCid",method=RequestMethod.GET)
	public abstract int deleteByCid(@RequestParam("cid") Integer cid);
}
