package com.cjh.study.authserver.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log4j2
@RestController
@RequestMapping(value = "base")
public class BaseController {

    @Value("${test.name}")
    private String name;

    @Bean // 自动扫描
    @LoadBalanced //这个注解的意思是在启动时先加载注册中心的域名列表
    public RestTemplate restTemplate() //这个方法用来发http请求
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @GetMapping
    public String hello() {
        log.info("配置属性：{}", name);
        return "hello test：" + name;
    }
}
