package com.tang.goods;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 *文件名: WebMvcConfig
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/31 16:32
 *描述: 这是一个示例
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("angular/index");
        registry.addViewController("/main.html").setViewName("angular/index");
        registry.addViewController("/login").setViewName("angular/index");
        registry.addViewController("/main.html").setViewName("angular/index");

    }
}

