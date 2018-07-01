package com.blog.wcl.consumer.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.consumer.constant.WebConst;
import com.blog.wcl.consumer.model.RestResponseBo;
import com.blog.wcl.consumer.service.TcommentsServiceInterface;
import com.blog.wcl.consumer.service.TcontentsServiceInterface;
import com.blog.wcl.consumer.util.DateKit;
import com.blog.wcl.consumer.util.MapCache;
import com.blog.wcl.consumer.util.TaleUtils;
import com.blog.wcl.consumer.util.Types;
import com.blog.wcl.user.entity.Tcomments;
import com.blog.wcl.user.entity.Tusers;


@Controller
@RequestMapping("comments")
public class TcommentsController {
	
	private MapCache cache = MapCache.single();
	
    public static String THEME = "themes/default"; 
    
    public static String STATUS = "approved";

	@Autowired
	private TcontentsServiceInterface tcontentsServiceInterface;
	
	
    @Resource
 	private TcommentsServiceInterface tcommentsServiceInterface;
	
    /**
     * 主页的页面主题
     * @param viewName
     * @return
     */
    public String render(String viewName) {
        return THEME + "/" + viewName;
    }
    
    public String render_404() {
        return "comm/error_404";
    }
	
    /**
     * 文章页
     *
     * @param request 请求
     * @param cid     文章主键
     * @return
     */
    @GetMapping(value = {"article/{cid}"})
    public String getArticle(HttpServletRequest request, @PathVariable String cid) {
    	Tcontents contents = tcontentsServiceInterface.getById(Integer.parseInt(cid));
        if (null == contents || "draft".equals(contents.getStatus())) {
            return this.render_404();
        }
        request.setAttribute("article", contents);
        request.setAttribute("is_post", true);
        completeArticle(request, contents);
        updateArticleHit(contents.getCid(), contents.getHits());
        return this.render("post");
    }
    
    
    /**
     * 抽取公共方法
     *
     * @param request
     * @param contents
     */
    private void completeArticle(HttpServletRequest request, Tcontents contents) {
        if (contents.getAllowComment()) {
        	Tcomments tcomments = new Tcomments();
        	tcomments.setCid(contents.getCid());
            List<Tcomments>  tcommentLists = tcommentsServiceInterface.findList(tcomments);
            request.setAttribute("comments", tcommentLists);
        }
    }
    
    
    /**
     * 更新文章的点击率
     *
     * @param cid
     * @param chits
     */
    private void updateArticleHit(Integer cid, Integer chits) {
        Integer hits = cache.hget("article", "hits");
        if (chits == null) {
            chits = 0;
        }
        hits = null == hits ? 1 : hits + 1;
        if (hits >= WebConst.HIT_EXCEED) {
            Tcontents temp = new Tcontents();
            temp.setCid(cid);
            temp.setHits(chits + hits);
            tcontentsServiceInterface.update(temp);
            cache.hset("article", "hits", 1);
        } else {
            cache.hset("article", "hits", hits);
        }
    }
    
    
    
    
	/**
	 * 文章发表
	 * 
	 * @param contents
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/commentSave")
	@ResponseBody
	public RestResponseBo publishArticle(Tcomments tcomments, HttpServletRequest request) {
		Tusers users = TaleUtils.getLoginUser(request);
		tcomments.setAuthor(users.getUsername());
		tcomments.setAuthorId(users.getUid());
		tcomments.setMail(users.getEmail());
		tcomments.setStatus(STATUS);
		tcomments.setType(Types.COMMENT.getType());
		 int time = DateKit.getCurrentUnixTime();
		 tcomments.setCreated(time);
		try {
			this.tcommentsServiceInterface.save(tcomments);
		} catch (Exception e) {
			String msg = "评论保存失败";
			System.out.println(msg);
			return RestResponseBo.fail(msg);
		}
		return RestResponseBo.ok();
	}
    
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String findList(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "15") int limit, HttpServletRequest request) {
		Tcomments tcomments = new Tcomments();
		tcomments.setSortColumns("created desc");
		com.blog.wcl.user.dto.Pager list = this.tcommentsServiceInterface.findPageList(tcomments, page, limit);
		request.setAttribute("comments", list);
		return "admin/comment_list";
	}
	
	
	   /**
     * 删除一条评论
     * @param coid
     * @return
     */
    @PostMapping(value = "delete")
    @ResponseBody
    public  RestResponseBo delete(@RequestParam Integer coid) {
        try {
        	Tcomments tcomments = tcommentsServiceInterface.getById(coid);
            if(null == tcomments){
                return RestResponseBo.fail("不存在该评论");
            }
            tcommentsServiceInterface.delete(coid);
        } catch (Exception e) {
            String msg = "评论删除失败";
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }
	
	
}
