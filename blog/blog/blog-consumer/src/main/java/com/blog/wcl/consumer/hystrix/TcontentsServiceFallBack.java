package com.blog.wcl.consumer.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.consumer.service.TcontentsServiceInterface;

@Component
public class TcontentsServiceFallBack implements TcontentsServiceInterface{

	@Override
	public int getTotalCount(Tcontents tcontents) {
		return 1;
	}

	@Override
	public List<Tcontents> findList(Tcontents tcontents) {
		List<Tcontents> list = new ArrayList<>();
		Tcontents tcontents1 = new Tcontents();
		tcontents1.setTitle("李亚冰");
		list.add(tcontents1);
		return list;
	}

	@Override
	public Pager findPageList(Tcontents tcontents, Integer pageNumber, Integer pageSize) {
		List<Tcontents> list = new ArrayList<>();
		Tcontents tcontents1 = new Tcontents();
		tcontents1.setTitle("李亚冰");
		list.add(tcontents1);
		Pager pager = new Pager();
		pager.setDatas(list);
		pager.setPageNumber(pageNumber);
		pager.setPageSize(pageSize);
		pager.setTotal(1);
		return pager;
	}

	@Override
	public int save(Tcontents tcontents) {
		return 0;
	}

	@Override
	public int update(Tcontents tcontents) {
		return 0;
	}

	@Override
	public int delete(Integer cid) {
		return 0;
	}

	@Override
	public Tcontents getById(Integer cid) {
		Tcontents tcontents1 = new Tcontents();
		tcontents1.setTitle("李亚冰");
		return tcontents1;
	}

	@Override
	public int getCountSize(Tcontents tcontents) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Tcontents> findRecentArticle(Integer pageSize) {
		List<Tcontents> list = new ArrayList<>();
		return list;
	}

}
