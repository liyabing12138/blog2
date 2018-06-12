package com.blog.wcl.article.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.article.entity.Trelationships;
import com.blog.wcl.article.mapper.TrelationshipsMapper;
import com.blog.wcl.article.service.TrelationshipsService;

@RestController
public class TrelationshipsServiceImpl implements TrelationshipsService<Trelationships, Integer> {

	@Autowired
	private TrelationshipsMapper trelationshipsMapper;

	@Override
	public int getTotalCount(Trelationships trelationships) {
		if (null == trelationships) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", trelationships);

		return trelationshipsMapper.getTotalCount(params);
	}

	@Override
	public  List<Trelationships> findList(Trelationships trelationships) {
		if (null == trelationships) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", trelationshipsMapper);

		return trelationshipsMapper.findList(trelationships);
	}

	@Override
	public Pager findPageList(Trelationships trelationships, Integer pageNumber, Integer pageSize) {
		int total = getTotalCount(trelationships);
		pageSize = pageSize == null || pageSize <= 0 ? 10 : pageSize;
		int totalPage = (total + pageSize - 1) / pageSize;
		pageNumber = pageNumber == null || pageNumber < 1 ? 1 : pageNumber > totalPage ? totalPage : pageNumber;
		Pager pager = new Pager(pageNumber, pageSize, total);
	
		if (total > 0) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("model", trelationships);
			params.put("pager", pager);
			List<Tcontents> list = trelationshipsMapper.findPageList(params);
			pager.setDatas(list); // 数据库集合
		}
		return pager;
	}

	@Override
	public int save(Trelationships trelationships) {
		if (null == trelationships) {
			throw new NullPointerException("entity bean is null");
		}
		return trelationshipsMapper.save(trelationships);
	}

	@Override
	public int update(Trelationships trelationships) {
		if (null == trelationships) {
			throw new NullPointerException("entity bean is null");
		}
		return trelationshipsMapper.update(trelationships);
	}

	@Override
	public int delete(Integer cid, Integer mid) {
		// TODO Auto-generated method stub
		return trelationshipsMapper.delete(cid, mid);
	}

	@Override
	public Trelationships getById(Integer cid, Integer mid) {
		// TODO Auto-generated method stub
		return trelationshipsMapper.getById(cid, mid);
	}

	@Override
	public int deleteByCid(Integer cid) {
		// TODO Auto-generated method stub
		return trelationshipsMapper.deleteByCid(cid);
	}
	
}
