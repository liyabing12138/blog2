package com.blog.wcl.article.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class LogFilter extends ZuulFilter {
	private static final Logger logger =LoggerFactory.getLogger(LogFilter.class);
	@Override
	public Object run() {
	   RequestContext context = RequestContext.getCurrentContext();
	   Object originalRequestPath = context.get(FilterConstants.REQUEST_URI_KEY);
	   String modifiedRequestPath = "/consumer/" + originalRequestPath;
	   context.put(FilterConstants.REQUEST_URI_KEY, modifiedRequestPath);
		logger.info("--------------pre1-------------------");
		HttpServletRequest request = context.getRequest();
		
		String token = request.getParameter("token");
		
		if(token == null){
			// 权限验证token为空
			logger.warn("token is null............");
			context.setSendZuulResponse(false);//代表结束请求，不在继续下级传递。
			context.setResponseStatusCode(401);
			context.setResponseBody("{\"result\":\"token is null\"}");
			context.getResponse().setContentType("text/html;charset=utf-8");
		}else {
			logger.info("token is OK............");
			
		}
		
		return null;
	}

	/**
	 * 是否开启过滤器，默认是false，开启过滤器
	 */
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	/**
	 * 用int值来定义order的执行顺序，数值越小 优先级越高。
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 过滤器的类型 分为 "pre",他是在请求路由之前被调用，一般用于身份权限验证，和记录日志等等
	 * 第二种类型分为 "routing",他是在请求之后被调用
	 * 第三种类型分为 "post" 在per和routing和微服务执行完方法之后调用，一般用于信息收集
	 * 第四种类型分为 "error" 一般可作为统一异常处理
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
