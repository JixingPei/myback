package com.oldpei.myback.configs.security;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oldpei.myback.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.ui.ModelMap;
//
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http相关的配置，包括登入登出、异常处理、会话管理等
        // 定制请求的授权规则,
        http.cors().and().csrf().disable().authorizeRequests()
                // 匹配许可，首页所有人可以访问
                .antMatchers("/").permitAll()
                // 匹配访问规则，需要vip1/2/3权限
                .antMatchers("/*").hasRole("admin")

                .and()


                // 开启自动配置的登录功能，如果没有权限，就会跳到登录页面！
                .formLogin()
                .successHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    Map<String,Object> map = new HashMap<>();
                    map.put("code",20000);
                    map.put("message","登录成功");
                    map.put("data",authentication);
                    PrintWriter out = response.getWriter();
                    out.write(JSON.toJSONString(map));
                    out.flush();
                    out.close();
                })
                // logout 注销请求，开启自动配置的注销的功能
                .and()
                .logout()
                .permitAll()
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put("code",20000);
                    map.put("message","登录成功");
                    map.put("data",authentication);
                    PrintWriter out = response.getWriter();
                    out.write(JSON.toJSONString(map));
                    out.flush();
                    out.close();
                }).permitAll();

    }

    //定义认证规则方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("MySecurityConfigurer AuthenticationManagerBuilder 调用...");

//在内存中定义，也可以在jdbc中去拿....
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("admin").roles("admin");
    }

}
