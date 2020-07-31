package com.oldpei.myback.configs;

import java.util.ArrayList;
import java.util.List;

import com.oldpei.myback.utils.token.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * papyless cunstom Configuration class.
 * @author jixing.pei
 * @version 1.0
 */
@Configuration
public class PapylessWebMvcConfigurer implements WebMvcConfigurer {
	
    @Autowired
    private Contants contants;
    
    private TokenInterceptor tokenInterceptor;
    
    /**
     * constructor
     * @param tokenInterceptor
     */
    public PapylessWebMvcConfigurer(TokenInterceptor tokenInterceptor) {
      this.tokenInterceptor = tokenInterceptor;
    }
	
	/**
     * Cross-domain problem solving
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")// 1 允许任何域名使用
                .allowedHeaders("*")// 2 允许任何头
                .allowedMethods("*")// 3 允许任何方法（post、get等）
                .allowCredentials(true);
    }
	
	/**
     * Image map path
     * @param registry
     */
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String os = System.getProperty("os.name");

		if (os.toLowerCase().startsWith("win")) {

			registry.addResourceHandler("/img/**").addResourceLocations("file:C:" + contants.getFilepath());
		} else {

			registry.addResourceHandler("/img/**").addResourceLocations("file:" + contants.getFilepath());
		}
	}

	/**
     * URL blocking configuration
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();

        excludePath.add("/getip");  
        excludePath.add("/healthcheck"); 
        excludePath.add("/login/check");     
        excludePath.add("/login/logout");   
        excludePath.add("/userAdmin/changePassword"); 
        excludePath.add("/static/**"); 
        excludePath.add("/assets/**"); 
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
