package com.udemy.backendninja.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor implements HandlerInterceptor{
	
	private final Log LOGGER = LogFactory.getLog(RequestTimeInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		request.setAttribute("starTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		long starTime = (long)request.getAttribute("starTime");
		LOGGER.info("--REQUEST URL: '"+ request.getRequestURL().toString()+"' TOTAL TIME: '"+(System.currentTimeMillis() - starTime) + "ms'" );
	}

}
