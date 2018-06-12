package com.blog.wcl.article.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.blog.wcl.article.entity.Tmetas;
import com.blog.wcl.article.entity.Trelationships;

public interface TrelationshipsMapper <T, PK extends Serializable>{
	/**
	 * 按主键查找对象
	 */
	public abstract Trelationships getById(PK pk1,PK pk2); 

	/**
	 * 获取总记录数
	 * @param params map中必须传入: 
	 * 		model - 查询条件的对象<T>
	 * @return
	 */
	public abstract int getTotalCount(Map<String, Object> params);
	
	/**
	 * 查询一个对象集合
	 * @param obj 查询条件的对象
	 * @return
	 */
	public abstract List<Trelationships> findList(Trelationships trelationships);

	/**
	 * 分页
	 * 必须传入两个对象：
	 * 		model - 查询条件的对象<T>  
	 * 		pager - 分页对象
	 * @param params
	 * @return
	 */
	public abstract List<Trelationships> findPageList(Map<String, Object> params);

	/**
	 * 保存
	 */
	public abstract int save(Trelationships trelationships);
	
	/**
	 * 更新
	 */
	public abstract int update(Trelationships trelationships);

	/**
	 * 删除
	 */
	public abstract int delete(PK pk1,PK pk2);
	
	/**
	 * 只是根据CID删除
	 * @param pk
	 * @return
	 */
	public abstract int deleteByCid(PK pk);
}
