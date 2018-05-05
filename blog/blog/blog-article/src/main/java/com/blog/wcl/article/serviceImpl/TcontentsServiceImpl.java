package com.blog.wcl.article.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.article.mapper.TcontentsMapper;
import com.blog.wcl.article.service.TcontentsService;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@RestController
public class TcontentsServiceImpl  implements TcontentsService {

	@Autowired
	private TcontentsMapper tcontentsMapper;
	
	@Override
	public List findList(Tcontents tcontents) {
		
		if (null == tcontents) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tcontents);

		return tcontentsMapper.findList(tcontents);
	}

	@Override
	public int getTotalCount(Tcontents tcontents) {
		if (null == tcontents) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tcontentsMapper);

		return tcontentsMapper.getTotalCount(params);
	}
}
