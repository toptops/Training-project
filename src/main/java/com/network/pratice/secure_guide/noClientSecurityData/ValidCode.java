package com.network.pratice.secure_guide.noClientSecurityData;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ���� �������� �ۼ�
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
				
				// �����̸��� ���� ���ڿ����� Ȯ��
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
			// ���� ���ڿ� ������ ��, �׸��� �ٽ� ����. �� ���ο� ��Ű�� ����� ���ؼ� ��.
			String newRandom = loginService.getRandomString();
			loginService.mapUserForRememberMe(username, newRandom);
			HttpSession session = request.getSession();
			session.invalidate();
			session = request.getSession(true);
			// ���� Ÿ�Ӿƿ� 15�� ����
			session.setMaxInactiveInterval(60 * 15);
			// ���ǿ� ���� �̸� ����
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
