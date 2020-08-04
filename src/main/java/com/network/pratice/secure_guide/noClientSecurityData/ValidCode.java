package com.network.pratice.secure_guide.noClientSecurityData;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 서블릿 기준으로 작성
 * 
 * @author seong
 *
 */
public class ValidCode {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		char[] password = request.getParameter("password").toCharArray();
		boolean rememberMe = Boolean.valueOf(request.getParameter("rememberme"));
		LoginServie loginService = new LoginServie();
		boolean validated = false;
		
		if(rememberMe) {
			if(request.getCookies()[0] != null && request.getCookies()[0].getValue() != null) {
				String[] value = request.getCookies()[0].getValue().split(";");
				
				if(value.length != 2) {
					// Set error and return
				}
				
				// 유저이름과 랜덤 문자열인지 확인
				if(!loginService.mappingExists(value[0], value[1])) {
					// (username, random) pair is checked
					// set error and return
				}
			} else {
				validated = loginService.isUserValid(username, password);
				if(!validated) {
					// Set error and return
				}
			}
			// 랜덤 문자열 가져온 후, 그리고 다시 저장. 즉 새로운 쿠키를 만들기 위해서 임.
			String newRandom = loginService.getRandomString();
			loginService.mapUserForRememberMe(username, newRandom);
			HttpSession session = request.getSession();
			session.invalidate();
			session = request.getSession(true);
			// 세션 타임아웃 15분 설정
			session.setMaxInactiveInterval(60 * 15);
			// 세션에 유저 이름 저장
			session.setAttribute("user", loginService.getUsername());
			Cookie loginCookie = new Cookie("rememberme", username + ";" + newRandom);
			response.addCookie(loginCookie);
			// Forward to welcome page
		} else {
			// Procced with regular authentication
		}
		Arrays.fill(password, ' ');
	}
}
