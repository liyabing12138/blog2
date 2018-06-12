package com.blog.wcl.article.entity;

import com.blog.wcl.article.entity.BaseEntity;

public class Trelationships extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:     
     * @字段:cid INT UNSIGNED(10)  
     */	
	private java.lang.Integer cid;

	/**
     * @备注:     
     * @字段:mid INT UNSIGNED(10)  
     */	
	private java.lang.Integer mid;
	public Trelationships(){
	}

	public Trelationships(
		java.lang.Integer cid,
		java.lang.Integer mid
	){
		this.cid = cid;
		this.mid = mid;
	}

	public void setCid(java.lang.Integer cid) {
		this.cid = cid;
	}
	 
	public java.lang.Integer getCid() {
		return this.cid;
	}
	public void setMid(java.lang.Integer mid) {
		this.mid = mid;
	}
	 
	public java.lang.Integer getMid() {
		return this.mid;
	}
}
