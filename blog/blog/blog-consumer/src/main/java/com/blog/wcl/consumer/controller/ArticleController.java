package com.blog.wcl.consumer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.wcl.article.dto.Pager;
import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.article.entity.Tmetas;
import com.blog.wcl.consumer.model.RestResponseBo;
import com.blog.wcl.consumer.service.TcontentsServiceInterface;
import com.blog.wcl.consumer.service.TcontentsServiceLoadBalancer;
import com.blog.wcl.consumer.service.TmetasServiceInterface;
import com.blog.wcl.consumer.util.Types;

@Controller
@RequestMapping("/admin/article")
public class ArticleController {
	@Autowired
	private TcontentsServiceInterface tcontentsServiceInterface;
	
//	@Autowired
//	private TcontentsServiceLoadBalancer  tcontentsServiceInterface;
	
	
	@Autowired
	private TmetasServiceInterface tmetasServiceInterface;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String findList(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "15") int limit,HttpServletRequest request){
		Tcontents tcontents = new Tcontents();
		tcontents.setSortColumns("created desc");
		Pager list=this.tcontentsServiceInterface.findPageList(tcontents, page, limit);
        request.setAttribute("articles", list);
		return  "admin/article_list";
	}
	
	
    /**
     * 文章发表
     * @param request
     * @return
     */
    @GetMapping(value = "/publish")
    public String newArticle(HttpServletRequest request) {
    	Tmetas tmetas = new Tmetas();
    	tmetas.setType(Types.CATEGORY.getType());
        List<Tmetas> categories = tmetasServiceInterface.findList(tmetas);
        request.setAttribute("categories", categories);
        return "admin/article_edit";
    }
    
    
    
    /**
     * 文章发表
     * @param contents
     * @param request
     * @return
     */
    @PostMapping(value = "/publish")
    @ResponseBody
    public RestResponseBo publishArticle(Tcontents tcontents,  HttpServletRequest request) {
//        UserVo users = this.user(request);
//        contents.setAuthorId(users.getUid());
        tcontents.setType(Types.ARTICLE.getType());
        if (StringUtils.isBlank(tcontents.getCategories())) {
        	tcontents.setCategories("默认分类");
        }
        try {
        	this.tcontentsServiceInterface.save(tcontents);
        } catch (Exception e) {
            String msg = "文章发布失败";
            System.out.println(msg);
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }
    
    
    /**
     * 文章编辑
     * @param cid
     * @param request
     * @return
     */
    @GetMapping(value = "/{cid}")
    public String editArticle(@PathVariable String cid, HttpServletRequest request) {
    	Tcontents tcontents = tcontentsServiceInterface.getById(Integer.parseInt(cid));
        request.setAttribute("contents", tcontents); 
        Tmetas tmetas = new Tmetas();
        tmetas.setType(Types.CATEGORY.getType());
        List<Tmetas> categories = tmetasServiceInterface.findList(tmetas);
        request.setAttribute("categories", categories);
        request.setAttribute("active", "article");
        return "admin/article_edit";
    }
    
    
    /**
     * 文章更新
     * @param contents
     * @param request
     * @return
     */
    @PostMapping(value = "/modify")
    @ResponseBody
    public RestResponseBo modifyArticle(Tcontents tcontents,HttpServletRequest request) {
    	tcontents.setAuthorId(2);
    	tcontents.setType(Types.ARTICLE.getType());
        try {
        	tcontentsServiceInterface.update(tcontents);
        } catch (Exception e) {
             String msg = "文章编辑失败";
             msg = e.getMessage();
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }
    
    /**
     * 删除文章
     * @param cid
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam int cid, HttpServletRequest request) {
        try {
        	tcontentsServiceInterface.delete(cid);
        } catch (Exception e) {
            String msg = "文章删除失败";
                msg = e.getMessage();
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }
}
