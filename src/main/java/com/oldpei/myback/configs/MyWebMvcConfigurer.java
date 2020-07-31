package com.oldpei.myback.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * Cross-domain problem solving
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

}
