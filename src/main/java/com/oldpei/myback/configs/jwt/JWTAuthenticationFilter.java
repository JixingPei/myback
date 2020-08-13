package com.oldpei.myback.configs.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
 * 该拦截器用于获取用户登录的信息
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        // 从输入流中获取到登录的信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>())
        );
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

/*        // 所以就是JwtUser啦
        CustomUser jwtUser = (CustomUser) authResult.getPrincipal();
        System.out.println("CustomUser:" + jwtUser.toString());
        String token = JwtTokenUtils.createToken(jwtUser.getUserId(), false);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的格式应该是 `Bearer token`
        response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
        // 允许前端跨域访问token这个响应头的内容。
        response.setHeader("Access-Control-Expose-Headers","token");
        response.getWriter().write(authResult.toString());*/

        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        String username = request.getParameter("username");
        String isRememberMe = request.getParameter("isRememberMe");
        String token = JwtTokenUtils.createToken(username, "1".equals(isRememberMe)?true:false);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的格式应该是 `Bearer token`
        response.setHeader(JwtTokenUtils.TOKEN_HEADER, JwtTokenUtils.TOKEN_PREFIX + token);
        // 允许前端跨域访问token这个响应头的内容。
        response.setHeader("Access-Control-Expose-Headers",JwtTokenUtils.TOKEN_HEADER);
        // 去除密码
//        ((CustomUser)authResult.getPrincipal()).setPassword(null);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",200);
        map.put("errMessage","登录成功");
        map.put("data",authResult);
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(map));
        out.flush();
        out.close();
    }

    // 这是验证失败时候调用的方法
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        /*response.getWriter().write("authentication failed, reason: " + failed.getMessage());*/
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",401);
//        if (ex instanceof UsernameNotFoundException || ex instanceof BadCredentialsException) {
//            map.put("message","用户名或密码错误");
//        } else if (ex instanceof DisabledException) {
//            map.put("message","账户被禁用");
//        } else {
//            map.put("message","登录失败!");
//        }
        map.put("errMessage","登录失败!");
        map.put("exception",failed.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(map));
        out.flush();
        out.close();
    }


}
