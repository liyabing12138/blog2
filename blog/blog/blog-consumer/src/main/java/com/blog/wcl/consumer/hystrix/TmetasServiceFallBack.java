package com.blog.wcl.consumer.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.article.entity.Tmetas;
import com.blog.wcl.consumer.service.TcontentsServiceInterface;
import com.blog.wcl.consumer.service.TmetasServiceInterface;

@Component
public class TmetasServiceFallBack implements TmetasServiceInterface{

	@Override
	public int getTotalCount(Tmetas tmetas) {
		return 1;
	}

	@Override
	public List<Tmetas> findList(Tmetas tmetas) {
		List<Tmetas> list = new ArrayList<Tmetas>();
		Tmetas tmetas1 = new Tmetas();
		tmetas1.setName("测试");
		list.add(tmetas1);
		return list;
	}

	@Override
	public Pager findPageList(Tmetas tmetas, Integer pageNumber, Integer pageSize) {
		List<Tmetas> list = new ArrayList<Tmetas>();
		Tmetas tmetas1 = new Tmetas();
		tmetas1.setName("测试");
		list.add(tmetas1);
		Pager pager = new Pager();
		pager.setDatas(list);
		pager.setPageNumber(pageNumber);
		pager.setPageSize(pageSize);
		pager.setTotal(1);
		return pager;
	}

	@Override
	public int saveTmetas(Tmetas tmetas) {
		return 0;
	}

	@Override
	public int update(Tmetas tmetas) {
		return 0;
	}

	@Override
	public int delete(Integer cid) {
		return 0;
	}

	@Override
	public Tmetas getById(Integer cid) {
		Tmetas tmetas1 = new Tmetas();
		tmetas1.setName("测试");
		return tmetas1;
	}

	

}
