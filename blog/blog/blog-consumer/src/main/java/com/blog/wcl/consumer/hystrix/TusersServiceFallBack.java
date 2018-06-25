package com.blog.wcl.consumer.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.blog.wcl.user.dto.Pager;
import com.blog.wcl.user.entity.Tusers;
import com.blog.wcl.user.service.TusersService;

@Component
public class TusersServiceFallBack implements TusersService{

	@Override
	public int getTotalCount(Tusers tusers) {
		return 1;
	}

	@Override
	public List<Tusers> findList(Tusers tusers) {
		List<Tusers> list = new ArrayList<>();
		Tusers tusers1 = new Tusers();
		tusers1.setUsername("李亚斌");
		list.add(tusers1);
		return list;
	}

	@Override
	public Pager findPageList(Tusers tusers, Integer pageNumber, Integer pageSize) {
		List<Tusers> list = new ArrayList<>();
		Tusers tusers1 = new Tusers();
		tusers1.setUsername("李亚斌");
		list.add(tusers1);
		Pager pager = new Pager();
		pager.setDatas(list);
		pager.setPageNumber(pageNumber);
		pager.setPageSize(pageSize);
		pager.setTotal(1);
		return pager;
	}

	@Override
	public int save(Tusers tusers) {
		return 0;
	}

	@Override
	public int update(Tusers tusers) {
		return 0;
	}

	@Override
	public int delete(Integer cid) {
		return 0;
	}

	@Override
	public Tusers  getById(Integer cid) {
		Tusers tusers = new Tusers();
		tusers.setUsername("李亚斌");
		return tusers;
	}

	@Override
	public Tusers login(Tusers tusers) throws Exception {
		return null;
	}

}
