package com.blog.wcl.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blog.wcl.article.dto.Pager;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.http.HttpMethod;

/**
 * 不使用生名式服务调用
 * @author Administrator
 *
 */
@Service
public class TcontentsServiceLoadBalancer {

	@Autowired
	private LoadBalancerClient loadBalancerClient;//ribbon 负载均衡客户端
	
	@HystrixCommand(fallbackMethod = "fallback",
			commandProperties = {
		      //默认10秒;如果并发数达到该设置值，请求会被拒绝和抛出异常并且fallback不会被调用。
		      @HystrixProperty(name=HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value="15")
		    })
	public Pager findPageList(){
		ServiceInstance si=loadBalancerClient.choose("blog-article");
		StringBuffer sb=new StringBuffer("");
		sb.append("http://");
		sb.append(si.getHost());
		sb.append(":");
		sb.append(si.getPort());
		sb.append("/article-service/findPageList");
		System.out.println(sb.toString());
		
		RestTemplate rt=new RestTemplate();
		ParameterizedTypeReference<Pager> typeRef
					=new ParameterizedTypeReference<Pager>(){};
		ResponseEntity<Pager>	resp=rt.exchange(sb.toString(), HttpMethod.GET, null, typeRef)	;	
		Pager plist=resp.getBody();
		return plist;
	}
	
	
	
}
