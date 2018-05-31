package com.blog.wcl.article.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

public class BlogFallbackProvider implements ZuulFallbackProvider {

	@Override
	public String getRoute() {
		// 返回为哪个服务进行网关的服务降级处理
	    return "blog-consumer";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse(){

			@Override
			public InputStream getBody() throws IOException {
				String input = "博客系统不可用，请联系管理员进行处理";
				return new ByteArrayInputStream(input.getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders header=new HttpHeaders();
				MediaType mt=new MediaType("application","json",Charset.forName("UTF-8"));
				header.setContentType(mt);
				return header;
			}

			@Override
			public void close() {
				
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return this.getStatusCode().value();
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public String getStatusText() throws IOException {
				
				return this.getStatusCode().getReasonPhrase();
			}
			
		};
		
	}

}
