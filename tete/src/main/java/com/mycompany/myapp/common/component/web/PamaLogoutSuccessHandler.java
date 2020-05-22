/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 *
 * <pre>
 * <b>History:</b>
 * Author	   Date		Description
 * 영수	  2016. 11. 18.   초기작성
 * </pre>
 *
 * @title
 * @packgename com.pama.app.component.common.web
 * @filename PamaLogoutSuccessHandler.java
 * @author 영수
 * @version 1.0, 2016. 11. 18. 초기작성
 * @see None
 */
package com.mycompany.myapp.common.component.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.mycompany.myapp.component.login.vo.SecurityLoginVO;

public class PamaLogoutSuccessHandler implements LogoutSuccessHandler {

	private static final Logger LOG = LoggerFactory.getLogger(PamaLogoutSuccessHandler.class);

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.logout.LogoutSuccessHandler#onLogoutSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		//LOG.debug("authentication ============== {}", authentication.getDetails());
		String ecode = "0";
		if (authentication !=null) {
			Object details = authentication.getPrincipal();
			if(details instanceof SecurityLoginVO) {
				SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;
				LOG.debug("logout onLogoutSuccess securityLoginVO message : {} ", securityLoginVO.getMessage());
			}
		}

		String retUrl = request.getParameter("retUrl");

		if (!"0".equals(ecode)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.sendRedirect("/login/loginFaile.do");
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			if(retUrl != null && retUrl != "") {
				response.sendRedirect(retUrl);
			}else {
				response.sendRedirect("/main.do");
			}
		}

	}

}
