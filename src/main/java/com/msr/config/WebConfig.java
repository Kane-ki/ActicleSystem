package com.msr.config;

import com.msr.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wjing
 * @create 2024-11-12 下午2:55
 * @desc
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
     @Autowired
    private LoginInterceptor loginInterceptor;

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register");//注册拦截器
    }
}
