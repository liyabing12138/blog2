package com.blog.wcl.consumer.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.blog.wcl.consumer.util.AdminCommons;
import com.blog.wcl.consumer.util.Commons;
@Component
public class BaseInterceptor implements HandlerInterceptor {

	
    @Resource
    private Commons commons;

    @Resource
    private AdminCommons adminCommons;

	
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		

	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		    httpServletRequest.setAttribute("commons", commons);//一些工具类和公共方法
	        httpServletRequest.setAttribute("adminCommons", adminCommons);
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		return true;
	}

}
