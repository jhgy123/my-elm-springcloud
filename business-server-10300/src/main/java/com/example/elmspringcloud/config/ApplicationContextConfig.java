package com.example.elmspringcloud.config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
//将getRestTemplate实例注入到spring容器中
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  //动态负载均衡，更加负载均衡策略进行选择使用那个微服务
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
