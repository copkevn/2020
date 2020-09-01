package com.turbo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: applicationContextConfig
 * @Author: HeYong
 * @Date: 2020/8/28 14:47
 * @Description: TODO Description
 * @Version: 1.0
 */
@Configuration
public class applicationContextConfig {
//    用@bean 注入的方式，把restTemplate注入到容器
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

