package com.example.poetry.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置一个虚拟路径去映射这个真实存在的物理路径
@Configuration
public class imgConfig implements WebMvcConfigurer {

    //@Value可以将配置文件的内容自动注入到属性内
    @Value("${file.location}")
    String filelocation;
    @Value("${file.path}")
    String filepath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(filepath).addResourceLocations("file:///" + filelocation);
    }
}

