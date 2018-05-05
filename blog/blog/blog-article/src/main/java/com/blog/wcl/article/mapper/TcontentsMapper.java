package com.blog.wcl.article.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * TcontentsDao
 */
public interface TcontentsMapper <T, PK extends Serializable> {

	


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
	public abstract List<T> findList(T obj);

	
}
