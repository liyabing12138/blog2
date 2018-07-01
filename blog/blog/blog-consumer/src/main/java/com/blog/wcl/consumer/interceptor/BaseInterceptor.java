package com.blog.wcl.consumer.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.blog.wcl.consumer.constant.WebConst;
import com.blog.wcl.consumer.service.TusersServiceInterface;
import com.blog.wcl.consumer.util.AdminCommons;
import com.blog.wcl.consumer.util.Commons;
import com.blog.wcl.consumer.util.IPKit;
import com.blog.wcl.consumer.util.MapCache;
import com.blog.wcl.consumer.util.SpringContextUtil;
import com.blog.wcl.consumer.util.TaleUtils;
import com.blog.wcl.consumer.util.Types;
import com.blog.wcl.consumer.util.UUID;
import com.blog.wcl.user.entity.Tusers;

@Component
public class BaseInterceptor implements HandlerInterceptor {
    private static final Logger LOGGE = LoggerFactory.getLogger(BaseInterceptor.class);
	
    private static final String USER_AGENT = "user-agent";
    
    @Resource
    private Commons commons;

    @Resource
    private AdminCommons adminCommons;

//    @Resource
//	private TusersServiceInterface tusersServiceInterface;
    
    private MapCache cache = MapCache.single();
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception arg3)
			throws Exception {
		

	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		    httpServletRequest.setAttribute("commons", commons);//一些工具类和公共方法
	        httpServletRequest.setAttribute("adminCommons", adminCommons);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		
		    String uri = request.getRequestURI();

	        LOGGE.info("UserAgent: {}", request.getHeader(USER_AGENT));
	        LOGGE.info("用户访问地址: {}, 来路地址: {}", uri, IPKit.getIpAddrByRequest(request));

	        //请求拦截处理
	        Tusers user = TaleUtils.getLoginUser(request);
	        if (null == user) {
	            Integer uid = TaleUtils.getCookieUid(request);
	            if (null != uid) {
	                //这里还是有安全隐患,cookie是可以伪造的
	                user = ((TusersServiceInterface) SpringContextUtil.getBean("tusersServiceInterface")).getById(uid);
	                request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
	            }
	        }
	        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") && null == user) {
	            response.sendRedirect(request.getContextPath() + "/admin/login");
	            return false;
	        }
	        //设置get请求的token
	        if (request.getMethod().equals("GET")) {
	            String csrf_token = UUID.UU64();
	            //默认存储30分钟
	            cache.hset(Types.CSRF_TOKEN.getType(), csrf_token, uri, 30 * 60);
	            request.setAttribute("_csrf_token", csrf_token);
	        }
	        return true;
	}

}
