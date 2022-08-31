package com.talkfree.talkfreebackend.configuration;

import com.talkfree.talkfreebackend.interceptor.DeviceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;


@Configuration
public class AllConfiguration extends WebMvcConfigurerAdapter {
    static final String ORIGINS[] = new String[] {"OPTIONS","GET", "POST", "PUT", "DELETE"};
    @Resource
    private DeviceInterceptor deviceInterceptor;

    @Resource
    RedisConnectionFactory factory;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(deviceInterceptor);
    }
}
