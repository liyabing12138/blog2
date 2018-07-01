package com.blog.wcl.user.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.wcl.user.dto.Pager;
import com.blog.wcl.user.entity.Tcomments;
import com.blog.wcl.user.entity.Tusers;
import com.blog.wcl.user.mapper.TcommentsMapper;
import com.blog.wcl.user.service.TcommentsService;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@RestController
public class TcommentsServiceImpl  implements TcommentsService {

	@Autowired
	private TcommentsMapper tcommentsMapper;
	
	
	@Override
	public int getTotalCount(@RequestBody Tcomments tcomments) {
		if (null == tcomments) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tcomments);

		return tcommentsMapper.getTotalCount(params);
	}

	@Override
	public List<Tcomments> findList(@RequestBody Tcomments tcomments) {
		if (null == tcomments) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tcomments);

		return tcommentsMapper.findList(tcomments);
	}

	@Override
	public Pager findPageList(@RequestBody Tcomments tcomments, Integer pageNumber, Integer pageSize) {
		int total = getTotalCount(tcomments);
		pageSize = pageSize == null || pageSize <= 0 ? 10 : pageSize;
		int totalPage = (total + pageSize - 1) / pageSize;
		pageNumber = pageNumber == null || pageNumber < 1 ? 1 : pageNumber > totalPage ? totalPage : pageNumber;
		Pager pager = new Pager(pageNumber, pageSize, total);
	
		if (total > 0) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("model", tcomments);
			params.put("pager", pager);
			List<Tusers> list = tcommentsMapper.findPageList(params);
			pager.setDatas(list); // 数据库集合
		}
		return pager;
	}

	@Override
	public int save(@RequestBody Tcomments tcomments) {
		if (null == tcomments) {
			throw new NullPointerException("entity bean is null");
		}
		int  cid = tcommentsMapper.save(tcomments);
		return cid;
	}

	@Override
	public int update(@RequestBody Tcomments tcomments) {
		if (null == tcomments) {
			throw new NullPointerException("entity bean is null");
		}
		return tcommentsMapper.update(tcomments);
	}

	@Override
	public int delete(Integer coid) {
		return tcommentsMapper.delete(coid);
	}

	@Override
	public Tcomments getById(Integer coid) {
		
		return (Tcomments) tcommentsMapper.getById(coid);
	}

	@Override
	public int getCountSize(@RequestBody Tcomments tcomments) {
		// TODO Auto-generated method stub
		return tcommentsMapper.getCountSize(tcomments);
	}

	@Override
	public List findRecentComment(Integer pageSize) {
		return tcommentsMapper.findRecentComment(pageSize);
	}
}
