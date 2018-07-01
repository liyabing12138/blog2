package com.blog.wcl.consumer.hystrix;

import java.util.List;

import com.blog.wcl.consumer.service.TattachServiceInterface;
import com.blog.wcl.user.dto.Pager;
import com.blog.wcl.user.entity.Tattach;

public class TattachServiceFallbcak implements TattachServiceInterface {

	@Override
	public int getTotalCount(Tattach tattach) {
		return 0;
	}

	@Override
	public List<Tattach> findList(Tattach tattach) {
		return null;
	}

	@Override
	public Pager findPageList(Tattach tattach, Integer pageNumber, Integer pageSize) {
		return null;
	}

	@Override
	public int save(Tattach tattach) {
		return 0;
	}

	@Override
	public int update(Tattach tattach) {
		return 0;
	}

	@Override
	public int delete(Integer id) {
		return 0;
	}

	@Override
	public Tattach getById(Integer id) {
		return new Tattach();
	}

	@Override
	public int getCountSize(Tattach tattach) {
		return 0;
	}

}
