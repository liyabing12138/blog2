package com.blog.wcl.user.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.wcl.user.dto.Pager;
import com.blog.wcl.user.entity.Tusers;
import com.blog.wcl.user.mapper.TusersMapper;
import com.blog.wcl.user.service.TusersService;
import com.blog.wcl.user.utils.TaleUtils;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class TusersServiceImpl  implements TusersService {

	@Autowired
	private TusersMapper tusersMapper;
	
	
	@Override
	public int getTotalCount(@RequestBody Tusers tusers) {
		if (null == tusers) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tusers);

		return tusersMapper.getTotalCount(params);
	}

	@Override
	public List<Tusers> findList(@RequestBody Tusers tusers) {
		if (null == tusers) {
			throw new NullPointerException("entity bean is null");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", tusers);

		return tusersMapper.findList(tusers);
	}

	@Override
	public Pager findPageList(@RequestBody Tusers tusers, Integer pageNumber, Integer pageSize) {
		int total = getTotalCount(tusers);
		pageSize = pageSize == null || pageSize <= 0 ? 10 : pageSize;
		int totalPage = (total + pageSize - 1) / pageSize;
		pageNumber = pageNumber == null || pageNumber < 1 ? 1 : pageNumber > totalPage ? totalPage : pageNumber;
		Pager pager = new Pager(pageNumber, pageSize, total);
	
		if (total > 0) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("model", tusers);
			params.put("pager", pager);
			List<Tusers> list = tusersMapper.findPageList(params);
			pager.setDatas(list); // 数据库集合
		}
		return pager;
	}

	@Override
	public int save(@RequestBody Tusers tusers) {
		if (null == tusers) {
			throw new NullPointerException("entity bean is null");
		}
		int  cid = tusersMapper.save(tusers);
		return cid;
	}

	@Override
	public int update(@RequestBody Tusers tusers) {
		if (null == tusers) {
			throw new NullPointerException("entity bean is null");
		}
		return tusersMapper.update(tusers);
	}

	@Override
	public int delete(Integer uid) {
		return tusersMapper.delete(uid);
	}

	@Override
	public Tusers getById(Integer uid) {
		
		return (Tusers) tusersMapper.getById(uid);
	}

	@Override
	public Tusers login(@RequestBody Tusers tusers) throws Exception {
		 if (StringUtils.isBlank(tusers.getUsername()) || StringUtils.isBlank(tusers.getPassword())) {
	            throw new Exception("用户名和密码不能为空");
	        }
		 String username = tusers.getUsername();
		 String password = tusers.getPassword();
		 String pwd = TaleUtils.MD5encode(username+password);
		   Map<String, Object> params = new HashMap<String, Object>();
			params.put("username", username);
			params.put("password", password);
		 return (Tusers) tusersMapper.login(params);
	}

}
