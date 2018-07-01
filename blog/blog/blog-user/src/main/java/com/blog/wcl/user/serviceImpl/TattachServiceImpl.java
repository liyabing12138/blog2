package com.blog.wcl.user.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.wcl.user.dto.Pager;
import com.blog.wcl.user.entity.Tattach;
import com.blog.wcl.user.entity.Tusers;
import com.blog.wcl.user.mapper.TattachMapper;
import com.blog.wcl.user.service.TattachService;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@RestController
public class TattachServiceImpl implements TattachService {

	@Autowired
	private TattachMapper tattachMapper;
	
	
	
	@Override
	public int getTotalCount(@RequestBody Tattach tattach) {
		if (null == tattach) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tattach);

		return tattachMapper.getTotalCount(params);
	}

	@Override
	public List<Tattach> findList(@RequestBody Tattach tattach) {
		if (null == tattach) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tattach);
		return tattachMapper.findList(tattach);
	}

	@Override
	public Pager findPageList(@RequestBody Tattach tattach, Integer pageNumber, Integer pageSize) {
		int total = getTotalCount(tattach);
		pageSize = pageSize == null || pageSize <= 0 ? 10 : pageSize;
		int totalPage = (total + pageSize - 1) / pageSize;
		pageNumber = pageNumber == null || pageNumber < 1 ? 1 : pageNumber > totalPage ? totalPage : pageNumber;
		Pager pager = new Pager(pageNumber, pageSize, total);
	
		if (total > 0) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("model", tattach);
			params.put("pager", pager);
			List<Tattach> list = tattachMapper.findPageList(params);
			pager.setDatas(list); // 数据库集合
		}
		return pager;
	}

	@Override
	public int save(@RequestBody Tattach tattach) {
		if (null == tattach) {
			throw new NullPointerException("entity bean is null");
		}
		int  tid = tattachMapper.save(tattach);
		return tid;
	}

	@Override
	public int update(@RequestBody Tattach tattach) {
		if (null == tattach) {
			throw new NullPointerException("entity bean is null");
		}
		return tattachMapper.update(tattach);
	}

	@Override
	public int delete(Integer id) {
		return tattachMapper.delete(id);
	}

	@Override
	public Tattach getById(Integer id) {
		return (Tattach) tattachMapper.getById(id);
	}

	@Override
	public int getCountSize(@RequestBody Tattach tattach) {
		// TODO Auto-generated method stub
		return tattachMapper.getCountSize(tattach);
	}
}
