package com.network.pratice.secure_guide.noClientSecurityData;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class badCode {
	
	/**
	 * 잘못된 코드, 중간에 로그인 쿠키 생성부분에 민감데이터중 하나인 패스워드가 그대로 들어가 있다.
	 * 
	 * @param request
	 * @param response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		char[] password = request.getParameter("password").toCharArray();
		boolean rememberMe = Boolean.valueOf(request.getParameter("rememberme"));
		
		LoginServie loginService = new LoginServiceImpl();
		if(rememberMe) {
			if(request.getCookies()[0] != null && request.getCookies()[0].getValue() != null) {
				String[] value = request.getCookies()[0].getValue().split(";");
				
				if(!loginService.isUserValid(value[0], value[1].toCharArray())) {
					// Set error and return
				} else {
					// Forward to welcome page
				}
			} else {
				boolean validated = loginService.isUserValid(username, password);
				if(validated) {
					Cookie loginCookie = new Cookie("rememberme", username + ";" + new String(password));
					response.addCookie(loginCookie);
					// Forward to welcome page
				} else {
					// Set error and return
				}
			}
		} else {
			// Procced with regular authentication
		}
		Arrays.fill(password, ' ');
	}
}
