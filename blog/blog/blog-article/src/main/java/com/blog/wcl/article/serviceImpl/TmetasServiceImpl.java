package com.blog.wcl.article.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.article.entity.Tmetas;
import com.blog.wcl.article.mapper.TcontentsMapper;
import com.blog.wcl.article.mapper.TmetasMapper;
import com.blog.wcl.article.service.TmetasService;

/**
 * 基本CURD操作在 否则自行声明接口，实现方法
 */
@RestController
public class TmetasServiceImpl  implements TmetasService {


	@Autowired
	private TmetasMapper tmetasMapper;
	
	@Autowired
	private TcontentsMapper tcontentsMapper;
	
	
	@Override
	public int getTotalCount(Tmetas tmetas) {
		if (null == tmetas) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tmetas);

		return tmetasMapper.getTotalCount(params);
	}

	@Override
	public List findList(Tmetas tmetas) {
		if (null == tmetas) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tmetas);

		return tmetasMapper.findList(tmetas);
	}

	@Override
	public Pager findPageList(Tmetas tmetas, Integer pageNumber, Integer pageSize) {
		int total = getTotalCount(tmetas);
		pageSize = pageSize == null || pageSize <= 0 ? 10 : pageSize;
		int totalPage = (total + pageSize - 1) / pageSize;
		pageNumber = pageNumber == null || pageNumber < 1 ? 1 : pageNumber > totalPage ? totalPage : pageNumber;
		Pager pager = new Pager(pageNumber, pageSize, total);
	
		if (total > 0) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("model", tmetas);
			params.put("pager", pager);
			List<Tcontents> list = tmetasMapper.findPageList(params);
			pager.setDatas(list); // 数据库集合
		}
		return pager;
	}

	
	
	@Override
	public int saveTmetas(@RequestBody Tmetas tmetas) {
		if (null == tmetas) {
			throw new NullPointerException("entity bean is null");
		}
		Tmetas tmetas1 = (Tmetas) tmetasMapper.getById(tmetas.getMid());
		if(tmetas1 == null){
			return	tmetasMapper.save(tmetas);
		}
		
		return tmetasMapper.update(tmetas);
	}
	@Override
	public int update(@RequestBody Tmetas tmetas) {
		if (null == tmetas) {
			throw new NullPointerException("entity bean is null");
		}
		return tmetasMapper.update(tmetas);
	}
	@Override
	public int delete(Integer cid) {
		return tmetasMapper.delete(cid);
	}
	@Override
	public Tmetas getById(Integer cid) {
		return (Tmetas) tmetasMapper.getById(cid);
	}

	@Override
	public Object getByName(String name) {
		return tmetasMapper.getByName(name);
	}

	@Override
	public int getCountSize(@RequestBody Tmetas tmetas) {
		return tmetasMapper.getCountSize(tmetas);
	}
	
	
}
