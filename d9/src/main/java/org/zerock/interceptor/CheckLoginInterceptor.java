package org.zerock.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import lombok.extern.log4j.Log4j;

@Log4j
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean result = false;
		
		String uri = request.getRequestURI();
		
		HttpSession session = request.getSession();
		
		Cookie loginCookie = WebUtils.getCookie(request, "login");
		
		if(session.getAttribute("member") != null) {
			
			result = true;
			
		} else if(loginCookie != null) {
			
			//지난 로그인 했을때의 jsessionid의 값
			String key = loginCookie.getValue();
			
			log.info("Cookie Value: " + key);
			
		} else {
			
			response.sendRedirect("/login");
			
			log.info("uri: " + uri);
			
			request.getSession().setAttribute("uri", uri);
		}
		
		log.info("check login user: " + result);
		
		return result;
	}
	
}
