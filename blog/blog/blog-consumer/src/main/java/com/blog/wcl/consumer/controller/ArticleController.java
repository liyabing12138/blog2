package com.blog.wcl.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.consumer.service.TcontentsServiceInterface;

@RestController
public class ArticleController {
	@Autowired
	private TcontentsServiceInterface tcontentsServiceInterface;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Tcontents> findList(){
		Tcontents tcontents = new Tcontents();
		List<Tcontents> list=this.tcontentsServiceInterface.findList(tcontents);
		return  list;
	}
	
	
}
