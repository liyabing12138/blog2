package com.blog.wcl.consumer.hystrix;

import java.util.ArrayList;
import java.util.List;

import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.consumer.service.TcommentsServiceInterface;
import com.blog.wcl.user.dto.Pager;
import com.blog.wcl.user.entity.Tcomments;

public class TcommentsServiceFallbcak implements TcommentsServiceInterface {

	@Override
	public int getTotalCount(Tcomments tcomments) {
		return 0;
	}

	@Override
	public List<Tcomments> findList(Tcomments tcomments) {
		return null;
	}

	@Override
	public Pager findPageList(Tcomments tcomments, Integer pageNumber, Integer pageSize) {
		return null;
	}

	@Override
	public int save(Tcomments tcomments) {
		return 0;
	}

	@Override
	public int update(Tcomments tcomments) {
		return 0;
	}

	@Override
	public int delete(Integer coid) {
		return 0;
	}

	@Override
	public Tcomments getById(Integer coid) {
		return new Tcomments();
	}

	@Override
	public int getCountSize(Tcomments tcomments) {
		return 0;
	}

	@Override
	public List<Tcomments> findRecentComment(Integer pageSize) {
		List<Tcomments> list = new ArrayList<Tcomments>();
		return list;
	}

}
