package com.blog.wcl.user.entity;

import com.blog.wcl.user.entity.BaseEntity;

public class Tusers extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:     
     * @字段:uid INT UNSIGNED(10)  
     */	
	private java.lang.Integer uid;

	/**
     * @备注:     
     * @字段:username VARCHAR(32)  
     */	
	private java.lang.String username;

	/**
     * @备注:     
     * @字段:password VARCHAR(64)  
     */	
	private java.lang.String password;

	/**
     * @备注:     
     * @字段:email VARCHAR(200)  
     */	
	private java.lang.String email;

	/**
     * @备注:     
     * @字段:home_url VARCHAR(200)  
     */	
	private java.lang.String homeUrl;

	/**
     * @备注:     
     * @字段:screen_name VARCHAR(32)  
     */	
	private java.lang.String screenName;

	/**
     * @备注:     
     * @字段:created INT UNSIGNED(10)  
     */	
	private java.lang.Integer created;

	/**
     * @备注:     
     * @字段:activated INT UNSIGNED(10)  
     */	
	private java.lang.Integer activated;

	/**
     * @备注:     
     * @字段:logged INT UNSIGNED(10)  
     */	
	private java.lang.Integer logged;

	/**
     * @备注:     
     * @字段:group_name VARCHAR(16)  
     */	
	private java.lang.String groupName;
	public Tusers(){
	}

	public Tusers(
		java.lang.Integer uid
	){
		this.uid = uid;
	}

	public void setUid(java.lang.Integer uid) {
		this.uid = uid;
	}
	 
	public java.lang.Integer getUid() {
		return this.uid;
	}
	public void setUsername(java.lang.String username) {
		this.username = username;
	}
	 
	public java.lang.String getUsername() {
		return this.username;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	 
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	 
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setHomeUrl(java.lang.String homeUrl) {
		this.homeUrl = homeUrl;
	}
	 
	public java.lang.String getHomeUrl() {
		return this.homeUrl;
	}
	public void setScreenName(java.lang.String screenName) {
		this.screenName = screenName;
	}
	 
	public java.lang.String getScreenName() {
		return this.screenName;
	}
	public void setCreated(java.lang.Integer created) {
		this.created = created;
	}
	 
	public java.lang.Integer getCreated() {
		return this.created;
	}
	public void setActivated(java.lang.Integer activated) {
		this.activated = activated;
	}
	 
	public java.lang.Integer getActivated() {
		return this.activated;
	}
	public void setLogged(java.lang.Integer logged) {
		this.logged = logged;
	}
	 
	public java.lang.Integer getLogged() {
		return this.logged;
	}
	public void setGroupName(java.lang.String groupName) {
		this.groupName = groupName;
	}
	 
	public java.lang.String getGroupName() {
		return this.groupName;
	}
}
