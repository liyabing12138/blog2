package com.blog.wcl.user.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页实体dto
 */
public class Pager implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 页码 从1开始
	 */
	private int pageNumber;

	/**
	 * 每页条数
	 */
	private int pageSize;

	/**
	 * 总记录数
	 */
	private int total;

	/**
	 * 总页数
	 */
	private int totalPages;

	/**
	 * 每页记录数
	 */
	private List<?> datas;

	/**
	 * 页面显示列表
	 */
	private List<Integer> segment;

	public Pager() {
		this.pageNumber = 1;
		this.pageSize = 10;
	}

	public Pager(int pageNumber, int pageSize, int total) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.total = total;
		if (total > 0 && pageSize > 0) {
			this.totalPages = (total - 1) / pageSize + 1;
			if (this.pageNumber > totalPages) {
				this.pageNumber = totalPages;
			}
		}
	}

	public int getBegin(){
		return pageSize*(pageNumber-1);
	}
	
	public int getPageNumber() {

		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<?> getDatas() {
		return datas;
	}

	public void setDatas(List<?> datas) {
		this.datas = datas;
	}
}
