package com.oldpei.myback.configs;

import com.oldpei.myback.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    private ConstantsFromYaml contants;
    @Autowired
    private MyInterceptor myInterceptor;
    /**
     * Cross-domain problem solving
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                // 1 允许任何域名使用
                .allowedHeaders("*")
                // 2 允许任何头
                .allowedMethods("*")
                // 3 允许任何方法（post、get等）
                .allowCredentials(true);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + contants.getFilepath());
    }

    /**
     * URL blocking configuration
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/static/**");
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
