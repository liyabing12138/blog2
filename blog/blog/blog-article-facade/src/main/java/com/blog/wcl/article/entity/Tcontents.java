package com.blog.wcl.article.entity;

import com.blog.wcl.article.entity.BaseEntity;

public class Tcontents extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:     
     * @字段:cid INT UNSIGNED(10)  
     */	
	private java.lang.Integer cid;

	/**
     * @备注:     
     * @字段:title VARCHAR(200)  
     */	
	private java.lang.String title;

	/**
     * @备注:     
     * @字段:slug VARCHAR(200)  
     */	
	private java.lang.String slug;

	/**
     * @备注:     
     * @字段:created INT UNSIGNED(10)  
     */	
	private java.lang.Integer created;

	/**
     * @备注:     
     * @字段:modified INT UNSIGNED(10)  
     */	
	private java.lang.Integer modified;

	/**
     * @备注:内容文字     
     * @字段:content TEXT(65535)  
     */	
	private java.lang.String content;

	/**
     * @备注:     
     * @字段:author_id INT UNSIGNED(10)  
     */	
	private java.lang.Integer authorId;

	/**
     * @备注:     
     * @字段:type VARCHAR(16)  
     */	
	private java.lang.String type;

	/**
     * @备注:     
     * @字段:status VARCHAR(16)  
     */	
	private java.lang.String status;

	/**
     * @备注:     
     * @字段:tags VARCHAR(200)  
     */	
	private java.lang.String tags;

	/**
     * @备注:     
     * @字段:categories VARCHAR(200)  
     */	
	private java.lang.String categories;

	/**
     * @备注:     
     * @字段:hits INT UNSIGNED(10)  
     */	
	private java.lang.Integer hits;

	/**
     * @备注:     
     * @字段:comments_num INT UNSIGNED(10)  
     */	
	private java.lang.Integer commentsNum;

	/**
     * @备注:     
     * @字段:allow_comment BIT(0)  
     */	
	private java.lang.Boolean allowComment;

	/**
     * @备注:     
     * @字段:allow_ping BIT(0)  
     */	
	private java.lang.Boolean allowPing;

	/**
     * @备注:     
     * @字段:allow_feed BIT(0)  
     */	
	private java.lang.Boolean allowFeed;
	public Tcontents(){
	}

	public Tcontents(
		java.lang.Integer cid
	){
		this.cid = cid;
	}

	public void setCid(java.lang.Integer cid) {
		this.cid = cid;
	}
	 
	public java.lang.Integer getCid() {
		return this.cid;
	}
	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	 
	public java.lang.String getTitle() {
		return this.title;
	}
	public void setSlug(java.lang.String slug) {
		this.slug = slug;
	}
	 
	public java.lang.String getSlug() {
		return this.slug;
	}
	public void setCreated(java.lang.Integer created) {
		this.created = created;
	}
	 
	public java.lang.Integer getCreated() {
		return this.created;
	}
	public void setModified(java.lang.Integer modified) {
		this.modified = modified;
	}
	 
	public java.lang.Integer getModified() {
		return this.modified;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	 
	public java.lang.String getContent() {
		return this.content;
	}
	public void setAuthorId(java.lang.Integer authorId) {
		this.authorId = authorId;
	}
	 
	public java.lang.Integer getAuthorId() {
		return this.authorId;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	 
	public java.lang.String getType() {
		return this.type;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	 
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setTags(java.lang.String tags) {
		this.tags = tags;
	}
	 
	public java.lang.String getTags() {
		return this.tags;
	}
	public void setCategories(java.lang.String categories) {
		this.categories = categories;
	}
	 
	public java.lang.String getCategories() {
		return this.categories;
	}
	public void setHits(java.lang.Integer hits) {
		this.hits = hits;
	}
	 
	public java.lang.Integer getHits() {
		return this.hits;
	}
	public void setCommentsNum(java.lang.Integer commentsNum) {
		this.commentsNum = commentsNum;
	}
	 
	public java.lang.Integer getCommentsNum() {
		return this.commentsNum;
	}
	public void setAllowComment(java.lang.Boolean allowComment) {
		this.allowComment = allowComment;
	}
	 
	public java.lang.Boolean getAllowComment() {
		return this.allowComment;
	}
	public void setAllowPing(java.lang.Boolean allowPing) {
		this.allowPing = allowPing;
	}
	 
	public java.lang.Boolean getAllowPing() {
		return this.allowPing;
	}
	public void setAllowFeed(java.lang.Boolean allowFeed) {
		this.allowFeed = allowFeed;
	}
	 
	public java.lang.Boolean getAllowFeed() {
		return this.allowFeed;
	}
}
