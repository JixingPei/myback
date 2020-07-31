package com.oldpei.myback.utils.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Token Interceptor class.
 * 
 * @author ben.zhang
 * @version 1.0
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(TokenInterceptor.class);

	@Autowired
	private TokenUtil tokenUtil;
	

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//
//		if (request.getMethod().equals("OPTIONS")) {
//			response.setStatus(HttpServletResponse.SC_OK);
//			return true;
//		}
//
//		HttpSession httpSession = request.getSession();
//		String token = request.getHeader("token");
//		String userId = (String) httpSession.getAttribute("userId");
//		if (null == token || token.equals("")) {
//			token = request.getParameter("token");
//		}
//		if (null == token || token.equals("")) {
//			token = (String) httpSession.getAttribute("token");
//		}
//
//		try {
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("application/json; charset=utf-8");
//			JSONObject json = new JSONObject();
//
//			if (token != null) {
//				boolean result = tokenUtil.verify(token);
//				if (result) {
//					if (!CommonUtils.strIsEmpty(userId)) {
//						if (loginStatusService.isLogin(userId, token, httpSession.getId())) {
//
//							return true;
//						} else {
//
//							json.put("msg", userId + " has been logged in by others");
//							json.put("code", "50001");
//							response.getWriter().append(json.toJSONString());
//							response.setStatus(50001);
//							return false;
//						}
//					} else {
//						json.put("msg", userId + " is session timeout");
//					}
//				} else {
//					json.put("msg", "token verify fail");
//				}
//			} else {
//
//				json.put("msg", "token is null");
//			}
//			json.put("code", "50000");
//			response.getWriter().append(json.toJSONString());
//			response.setStatus(50000);
//		} catch (Exception e) {
//			LOGGER.error("TokenInterceptor error : {}", e);
//			response.sendError(500);
//		}
//		return false;
//	}
}