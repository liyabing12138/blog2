package com.blog.wcl.consumer.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.wcl.article.entity.Tcontents;
import com.blog.wcl.article.entity.Tmetas;
import com.blog.wcl.consumer.constant.WebConst;
import com.blog.wcl.consumer.model.RestResponseBo;
import com.blog.wcl.consumer.service.TattachServiceInterface;
import com.blog.wcl.consumer.service.TcommentsServiceInterface;
import com.blog.wcl.consumer.service.TcontentsServiceInterface;
import com.blog.wcl.consumer.service.TmetasServiceInterface;
import com.blog.wcl.consumer.service.TusersServiceInterface;
import com.blog.wcl.consumer.util.Commons;
import com.blog.wcl.consumer.util.MapCache;
import com.blog.wcl.consumer.util.TaleUtils;
import com.blog.wcl.user.entity.StatisticsBo;
import com.blog.wcl.user.entity.Tattach;
import com.blog.wcl.user.entity.Tcomments;
import com.blog.wcl.user.entity.Tusers;


@Controller
@RequestMapping("/admin")
public class TusersController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TusersController.class);
	
    @Resource
	private TusersServiceInterface tusersServiceInterface;
    
    @Resource
 	private TattachServiceInterface tattachServiceInterface;
    
    
    @Resource
 	private TcommentsServiceInterface tcommentsServiceInterface;
    
    
	@Autowired
	private TcontentsServiceInterface tcontentsServiceInterface;
    
	@Autowired
	private TmetasServiceInterface tmetasServiceInterface;
	
    
    protected MapCache cache = MapCache.single();

    @GetMapping(value = "/login")
    public String login() {
        return "admin/login";
    }
    
    /**
     * admin 退出登录
     * @return
     */
    @GetMapping(value = "logoutUser")
    public String logout() {
        System.out.println("index-----------logout");
        return "admin/login";
    }
    
    /**
     * 个人设置页面
     */
    @GetMapping(value = "profile")
    public String profile() {
        return "admin/profile";
    }
    
    

    /**
     * 保存个人信息
     */
    @PostMapping(value = "/profile")
    @ResponseBody
    public RestResponseBo saveProfile(@RequestParam String screenName, @RequestParam String email, HttpServletRequest request, HttpSession session) {
    	Tusers users = TaleUtils.getLoginUser(request);
        if (StringUtils.isNotBlank(screenName) && StringUtils.isNotBlank(email)) {
        	Tusers temp = new Tusers();
            temp.setUid(users.getUid());
            temp.setScreenName(screenName);
            temp.setEmail(email);
            tusersServiceInterface.update(users);
            //更新session中的数据
            Tusers original = (Tusers) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
            original.setScreenName(screenName);
            original.setEmail(email);
            session.setAttribute(WebConst.LOGIN_SESSION_KEY, original);
        }
        return RestResponseBo.ok();
    }
    
    
    
    /**
     * 修改密码
     */
    @PostMapping(value = "/password")
    @ResponseBody
    public RestResponseBo upPwd(@RequestParam String oldPassword, @RequestParam String password, HttpServletRequest request,HttpSession session) {
    	Tusers users = TaleUtils.getLoginUser(request);
        if (StringUtils.isBlank(oldPassword) || StringUtils.isBlank(password)) {
            return RestResponseBo.fail("请确认信息输入完整");
        }

        if (!users.getPassword().equals(TaleUtils.MD5encode(users.getUsername() + oldPassword))) {
            return RestResponseBo.fail("旧密码错误");
        }
        if (password.length() < 6 || password.length() > 14) {
            return RestResponseBo.fail("请输入6-14位密码");
        }

        try {
        	Tusers temp = new Tusers();
            temp.setUid(users.getUid());
            String pwd = TaleUtils.MD5encode(users.getUsername() + password);
            temp.setPassword(pwd);
            tusersServiceInterface.update(temp);
            //更新session中的数据
            Tusers original= (Tusers)session.getAttribute(WebConst.LOGIN_SESSION_KEY);
            original.setPassword(pwd);
            session.setAttribute(WebConst.LOGIN_SESSION_KEY,original);
            return RestResponseBo.ok();
        } catch (Exception e){
            String msg = "密码修改失败";
            return RestResponseBo.fail(msg);
        }
    }
    
    
    /**
     * 管理后台登录
     * @param username
     * @param password
     * @param remeber_me
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "login")
    @ResponseBody
    public RestResponseBo doLogin(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam(required = false) String remeber_me,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        Integer error_count = cache.get("login_error_count");
        try {
        	Tusers loginuser = new Tusers();
        	loginuser.setUsername(username);
        	loginuser.setPassword(password);
        	Tusers user = tusersServiceInterface.login(loginuser);
        	if(user == null){
        		throw new Exception("用户名或密码错误");
        	}
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            if (StringUtils.isNotBlank(remeber_me)) {
                TaleUtils.setCookie(response, user.getUid());
            }
        } catch (Exception e) {
            error_count = null == error_count ? 1 : error_count + 1;
            if (error_count > 3) {
                return RestResponseBo.fail("您输入密码已经错误超过3次，请10分钟后尝试");
            }
            cache.set("login_error_count", error_count, 10 * 60);
            String msg = "登录失败";
            LOGGER.error(msg, e);
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

    /**
     * 注销
     * @param session
     * @param response
     */
    @RequestMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        session.removeAttribute(WebConst.LOGIN_SESSION_KEY);
        Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        try {
            response.sendRedirect(Commons.site_login());
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("注销失败", e);
        }
    }
    
    
    /**
     * 页面跳转
     * @return
     */
    @GetMapping(value = {"/index"})
    public String index(HttpServletRequest request){
        LOGGER.info("TusersController admin index method");
        StatisticsBo statisticsBo = new StatisticsBo();
        List<Tcomments>  comments =     tcommentsServiceInterface.findRecentComment(5);
       List<Tcontents>  articles =   tcontentsServiceInterface.findRecentArticle(5);
       int tattchCount =  tattachServiceInterface.getCountSize(new Tattach());
       int tommentCount  = tcommentsServiceInterface.getCountSize(new Tcomments());
       int articeCount  = tcontentsServiceInterface.getCountSize(new Tcontents());
       int tmetasCount  = tmetasServiceInterface.getCountSize(new Tmetas());
       statisticsBo.setAttachs(new Long(tattchCount));
       statisticsBo.setComments(new Long(tommentCount));
       statisticsBo.setArticles(new Long(articeCount));
       statisticsBo.setLinks(new Long(tmetasCount));
       request.setAttribute("statistics", statisticsBo);
       request.setAttribute("articles", articles);
       request.setAttribute("comments", comments);
        LOGGER.info("TusersController admin index method");
        return "admin/index";
    }
    
}
