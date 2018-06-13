package com.blog.wcl.consumer.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tmetas;
import com.blog.wcl.article.entity.Trelationships;
import com.blog.wcl.article.service.TrelationshipsService;

@Component
public class TrelationshipsServiceFallback implements TrelationshipsService{

	@Override
	public int getTotalCount(Trelationships trelationships) {
		
		return 1;
	}

	@Override
	public List findList(Trelationships trelationships) {
		List<Trelationships> list = new ArrayList<Trelationships>();
		Trelationships tmetas1 = new Trelationships();
		tmetas1.setCid(1);
		list.add(tmetas1);
		return list;
	}

	@Override
	public Pager findPageList(Trelationships trelationships, Integer pageNumber, Integer pageSize) {
		List<Trelationships> list = new ArrayList<Trelationships>();
		Trelationships tmetas1 = new Trelationships();
		tmetas1.setCid(1);
		list.add(tmetas1);
		Pager pager = new Pager();
		pager.setDatas(list);
		pager.setPageNumber(pageNumber);
		pager.setPageSize(pageSize);
		pager.setTotal(1);
		return pager;
	}

	@Override
	public int save(Trelationships trelationships) {
		
		return 0;
	}

	@Override
	public int update(Trelationships trelationships) {
		
		return 0;
	}

	@Override
	public int delete(Integer cid, Integer mid) {
		
		return 0;
	}

	@Override
	public Trelationships getById(Integer cid, Integer mid) {
		
		return null;
	}

	@Override
	public int deleteByCid(Integer cid) {
		
		return 0;
	}

	@Override
	public Trelationships getByMid(Integer mid) {
	
		return null;
	}

}
