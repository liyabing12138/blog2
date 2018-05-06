package com.blog.wcl.consumer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.consumer.service.TcontentsServiceInterface;

@Controller
public class ArticleController {
	@Autowired
	private TcontentsServiceInterface tcontentsServiceInterface;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String findList(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "15") int limit,HttpServletRequest request){
		Tcontents tcontents = new Tcontents();
		tcontents.setSortColumns("created desc");
		Pager list=this.tcontentsServiceInterface.findPageList(tcontents, page, limit);
        request.setAttribute("articles", list);
		return  "admin/article_list";
	}
	
	
	
	
	
}
