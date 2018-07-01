package com.blog.wcl.user.entity;

public class Tcomments extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:     
     * @字段:coid INT UNSIGNED(10)  
     */	
	private java.lang.Integer coid;

	/**
     * @备注:     
     * @字段:cid INT UNSIGNED(10)  
     */	
	private java.lang.Integer cid;

	/**
     * @备注:     
     * @字段:created INT UNSIGNED(10)  
     */	
	private java.lang.Integer created;

	/**
     * @备注:     
     * @字段:author VARCHAR(200)  
     */	
	private java.lang.String author;

	/**
     * @备注:     
     * @字段:author_id INT UNSIGNED(10)  
     */	
	private java.lang.Integer authorId;

	/**
     * @备注:     
     * @字段:owner_id INT UNSIGNED(10)  
     */	
	private java.lang.Integer ownerId;

	/**
     * @备注:     
     * @字段:mail VARCHAR(200)  
     */	
	private java.lang.String mail;

	/**
     * @备注:     
     * @字段:url VARCHAR(200)  
     */	
	private java.lang.String url;

	/**
     * @备注:     
     * @字段:ip VARCHAR(64)  
     */	
	private java.lang.String ip;

	/**
     * @备注:     
     * @字段:agent VARCHAR(200)  
     */	
	private java.lang.String agent;

	/**
     * @备注:     
     * @字段:content TEXT(65535)  
     */	
	private java.lang.String content;

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
     * @字段:parent INT UNSIGNED(10)  
     */	
	private java.lang.Integer parent;
	public Tcomments(){
	}

	public Tcomments(
		java.lang.Integer coid
	){
		this.coid = coid;
	}

	public void setCoid(java.lang.Integer coid) {
		this.coid = coid;
	}
	 
	public java.lang.Integer getCoid() {
		return this.coid;
	}
	public void setCid(java.lang.Integer cid) {
		this.cid = cid;
	}
	 
	public java.lang.Integer getCid() {
		return this.cid;
	}
	public void setCreated(java.lang.Integer created) {
		this.created = created;
	}
	 
	public java.lang.Integer getCreated() {
		return this.created;
	}
	public void setAuthor(java.lang.String author) {
		this.author = author;
	}
	 
	public java.lang.String getAuthor() {
		return this.author;
	}
	public void setAuthorId(java.lang.Integer authorId) {
		this.authorId = authorId;
	}
	 
	public java.lang.Integer getAuthorId() {
		return this.authorId;
	}
	public void setOwnerId(java.lang.Integer ownerId) {
		this.ownerId = ownerId;
	}
	 
	public java.lang.Integer getOwnerId() {
		return this.ownerId;
	}
	public void setMail(java.lang.String mail) {
		this.mail = mail;
	}
	 
	public java.lang.String getMail() {
		return this.mail;
	}
	public void setUrl(java.lang.String url) {
		this.url = url;
	}
	 
	public java.lang.String getUrl() {
		return this.url;
	}
	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}
	 
	public java.lang.String getIp() {
		return this.ip;
	}
	public void setAgent(java.lang.String agent) {
		this.agent = agent;
	}
	 
	public java.lang.String getAgent() {
		return this.agent;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	 
	public java.lang.String getContent() {
		return this.content;
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
	public void setParent(java.lang.Integer parent) {
		this.parent = parent;
	}
	 
	public java.lang.Integer getParent() {
		return this.parent;
	}
}
