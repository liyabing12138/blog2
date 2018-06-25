package com.blog.wcl.article.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.article.entity.Tmetas;
import com.blog.wcl.article.entity.Trelationships;
import com.blog.wcl.article.mapper.TcontentsMapper;
import com.blog.wcl.article.mapper.TmetasMapper;
import com.blog.wcl.article.mapper.TrelationshipsMapper;
import com.blog.wcl.article.service.TcontentsService;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@RestController
public class TcontentsServiceImpl implements TcontentsService  {

	@SuppressWarnings("rawtypes")
	@Autowired
	private TcontentsMapper tcontentsMapper;
	
	@Autowired
	private TmetasMapper tmetasMapper;
	
	@Autowired
	private TrelationshipsMapper trelationshipsMapper;
	
	@Override
	public List findList(@RequestBody Tcontents tcontents) {
		
		if (null == tcontents) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tcontents);

		return tcontentsMapper.findList(tcontents);
	}
	@Override
	public int getTotalCount(@RequestBody Tcontents tcontents) {
		if (null == tcontents) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tcontents);

		return tcontentsMapper.getTotalCount(params);
	}
	
	@Override
	public Pager findPageList(@RequestBody Tcontents tcontents, Integer pageNumber, Integer pageSize) {
		System.out.println("########################");
/*		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		int total = getTotalCount(tcontents);
		pageSize = pageSize == null || pageSize <= 0 ? 10 : pageSize;
		int totalPage = (total + pageSize - 1) / pageSize;
		pageNumber = pageNumber == null || pageNumber < 1 ? 1 : pageNumber > totalPage ? totalPage : pageNumber;
		Pager pager = new Pager(pageNumber, pageSize, total);
	
		if (total > 0) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("model", tcontents);
			params.put("pager", pager);
			List<Tcontents> list = tcontentsMapper.findPageList(params);
			pager.setDatas(list); // 数据库集合
		}
		return pager;
	}
	@Override
	public int save(@RequestBody Tcontents tcontents) {
		if (null == tcontents) {
			throw new NullPointerException("entity bean is null");
		}
		int  cid = tcontentsMapper.save(tcontents);
		String[] categorys = tcontents.getCategories().split(",");
		List<Tmetas> tmetasList = new ArrayList<Tmetas>();
		for (String category : categorys) {
			Tmetas tmetas = (Tmetas) tmetasMapper.getByName(category);
			tmetasList.add(tmetas);
		}
		
		for (Tmetas tmetas : tmetasList) {
			Trelationships  trelationships = new Trelationships();		
			trelationships.setCid(cid);
			trelationships.setMid(tmetas.getMid());
			trelationshipsMapper.save(trelationships);
		}
		return cid;
	}
	
	
	@Override
	public int update(@RequestBody Tcontents tcontents) {
		if (null == tcontents) {
			throw new NullPointerException("entity bean is null");
		}
		String[] categorys = tcontents.getCategories().split(",");
		List<Tmetas> tmetasList = new ArrayList<Tmetas>();
		for (String category : categorys) {
			Tmetas tmetas = (Tmetas) tmetasMapper.getByName(category);
			tmetasList.add(tmetas);
		}
		trelationshipsMapper.deleteByCid(tcontents.getCid());
		for (Tmetas tmetas : tmetasList) {
			Trelationships  trelationships = new Trelationships();		
			trelationships.setCid(tcontents.getCid());
			trelationships.setMid(tmetas.getMid());
			trelationshipsMapper.save(trelationships);
		}
		return tcontentsMapper.update(tcontents);
	}
	@Override
	public int delete(Integer cid) {
		trelationshipsMapper.deleteByCid(cid);
		return tcontentsMapper.delete(cid);
	}
	@Override
	public Tcontents getById( Integer cid) {
		System.out.println("cid="+cid);
		return (Tcontents) tcontentsMapper.getById(cid);
	}
}
