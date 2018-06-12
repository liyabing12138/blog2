package com.blog.wcl.article.entity;

import com.blog.wcl.article.entity.BaseEntity;

public class Tmetas extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:     
     * @字段:mid INT UNSIGNED(10)  
     */	
	private java.lang.Integer mid;

	/**
     * @备注:     
     * @字段:name VARCHAR(200)  
     */	
	private java.lang.String name;

	/**
     * @备注:     
     * @字段:slug VARCHAR(200)  
     */	
	private java.lang.String slug;

	/**
     * @备注:     
     * @字段:type VARCHAR(32)  
     */	
	private java.lang.String type;

	/**
     * @备注:     
     * @字段:description VARCHAR(200)  
     */	
	private java.lang.String description;

	/**
     * @备注:     
     * @字段:sort INT UNSIGNED(10)  
     */	
	private java.lang.Integer sort;

	/**
     * @备注:     
     * @字段:parent INT UNSIGNED(10)  
     */	
	private java.lang.Integer parent;
	
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Tmetas(){
	}

	public Tmetas(
		java.lang.Integer mid
	){
		this.mid = mid;
	}

	public void setMid(java.lang.Integer mid) {
		this.mid = mid;
	}
	 
	public java.lang.Integer getMid() {
		return this.mid;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	 
	public java.lang.String getName() {
		return this.name;
	}
	public void setSlug(java.lang.String slug) {
		this.slug = slug;
	}
	 
	public java.lang.String getSlug() {
		return this.slug;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	 
	public java.lang.String getType() {
		return this.type;
	}
	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	 
	public java.lang.String getDescription() {
		return this.description;
	}
	public void setSort(java.lang.Integer sort) {
		this.sort = sort;
	}
	 
	public java.lang.Integer getSort() {
		return this.sort;
	}
	public void setParent(java.lang.Integer parent) {
		this.parent = parent;
	}
	 
	public java.lang.Integer getParent() {
		return this.parent;
	}
}
