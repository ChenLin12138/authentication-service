package com.chenlin.authentication.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Chen Lin
 * @date 2019-09-09
 */

//添加此注解，SpringBoot会自动加载这个Filter
@WebFilter(urlPatterns = "/*",filterName = "UserContextFilter")
public class UserContextFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		//检索调用http首部中的值，将这些值存储在UserContextHolder中的UserContext中
		UserContextHolder.getContext().setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
		//获取userid设置进入contextHolder
		UserContextHolder.getContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
		//获取token设置进入contextHolder
		UserContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
		//获取orgid设置进入contextHolder
		UserContextHolder.getContext().setOrgId(httpServletRequest.getHeader(UserContext.ORG_ID));
		logger.debug("getLicense Correlation id:{}",UserContextHolder.getContext().getCorrelationId());
		chain.doFilter(httpServletRequest, response);
	}

}
