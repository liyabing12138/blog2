package com.blog.wcl.user.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * TcommentsDao
 */
public interface TcommentsMapper <T, PK extends Serializable> {

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
	
	/**
	 * 查询最近的评论
	 * @param pk
	 * @return
	 */
	public abstract List<T> findRecentComment(PK pk);
	
	/**
	 * 根据条件查询总数
	 * @param obj
	 * @return
	 */
	public abstract int getCountSize(T obj);
	
	
	/**
	 * 分页
	 */
	public abstract List<T> findPageList(Map<String, Object> params);

	/**
	 * 保存
	 */
	public abstract int save(T obj);
	
	/**
	 * 更新
	 */
	public abstract int update(T obj);

	/**
	 * 删除
	 */
	public abstract int delete(PK pk);
	
	/**
	 * 按主键查找对象
	 */
	public abstract T getById(PK pk); 
}