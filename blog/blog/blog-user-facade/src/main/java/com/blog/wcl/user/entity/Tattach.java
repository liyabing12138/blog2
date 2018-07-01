package com.blog.wcl.user.entity;

public class Tattach extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:     
     * @字段:id INT UNSIGNED(10)  
     */	
	private java.lang.Integer id;

	/**
     * @备注:     
     * @字段:fname VARCHAR(100)  
     */	
	private java.lang.String fname;

	/**
     * @备注:     
     * @字段:ftype VARCHAR(50)  
     */	
	private java.lang.String ftype;

	/**
     * @备注:     
     * @字段:fkey VARCHAR(100)  
     */	
	private java.lang.String fkey;

	/**
     * @备注:     
     * @字段:author_id INT(10)  
     */	
	private java.lang.Integer authorId;

	/**
     * @备注:     
     * @字段:created INT(10)  
     */	
	private java.lang.Integer created;
	public Tattach(){
	}

	public Tattach(
		java.lang.Integer id
	){
		this.id = id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	 
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setFname(java.lang.String fname) {
		this.fname = fname;
	}
	 
	public java.lang.String getFname() {
		return this.fname;
	}
	public void setFtype(java.lang.String ftype) {
		this.ftype = ftype;
	}
	 
	public java.lang.String getFtype() {
		return this.ftype;
	}
	public void setFkey(java.lang.String fkey) {
		this.fkey = fkey;
	}
	 
	public java.lang.String getFkey() {
		return this.fkey;
	}
	public void setAuthorId(java.lang.Integer authorId) {
		this.authorId = authorId;
	}
	 
	public java.lang.Integer getAuthorId() {
		return this.authorId;
	}
	public void setCreated(java.lang.Integer created) {
		this.created = created;
	}
	 
	public java.lang.Integer getCreated() {
		return this.created;
	}
}
