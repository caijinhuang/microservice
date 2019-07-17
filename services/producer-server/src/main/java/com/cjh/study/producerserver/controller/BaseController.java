package com.cjh.study.producerserver.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log4j2
@RestController
@RequestMapping(value = "go")
public class BaseController {

    @Bean // 自动扫描
    @LoadBalanced //这个注解的意思是在启动时先加载注册中心的域名列表
    public RestTemplate restTemplate() //这个方法用来发http请求
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;//ribbon负载均衡器

    //    @GetMapping
//    public String hello() {
//        //ServiceInstance 封装了服务的基本信息，如 IP，端口
//        ServiceInstance si = this.loadBalancerClient.choose("AUTH-SERVER");
//        //拼接访问服务的URL
//        StringBuffer sb = new StringBuffer();
//        //http://localhost:8762/getMenu
//        sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/base");
//
////        RestTemplate restTemplate = new RestTemplate();
//        String str = restTemplate.getForObject(sb.toString(),String.class);
//        return "请求结果："+str;
//    }
    @GetMapping
    public String go() {
        String result = restTemplate.getForObject("http://auth-server/base", String.class);
        return "result:" + result;
    }
}
