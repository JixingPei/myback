package com.oldpei.myback.configs.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 进行鉴权
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
//        // 如果请求头中没有Authorization信息则直接放行了
//        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
//            chain.doFilter(request, response);
//            return;
//        }
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
            responseError(response,new BadCredentialsException("token is null"));
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        String username = null;
        try {
            String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
            username = JwtTokenUtils.getUsername(token);
        } catch (ExpiredJwtException e) {
            responseError(response,e);
            return;
        } catch (Exception e) {
            responseError(response,e);
            return;
        }
        request.getSession().setAttribute("userId", username);
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(username));
        super.doFilterInternal(request, response, chain);
    }

    // 这里从token中获取用户信息并新建一个token
    private UsernamePasswordAuthenticationToken getAuthentication(String username) {
        if (username != null){
            return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
        }
        return null;
    }

    private void responseError(HttpServletResponse response, Exception ex) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        Map<String,Object> map = new HashMap<String,Object>();
        if (ex instanceof ExpiredJwtException) {
            map.put("code",50001);
            map.put("errMessage","用户登录凭证已过期, 请重新登录");
        } else if (ex instanceof BadCredentialsException) {
            map.put("code",50002);
            map.put("errMessage","用户验证失败");
        } else {
            map.put("code",90000);
            map.put("errMessage","系统异常!");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(map));
        out.flush();
        out.close();
    }
}
