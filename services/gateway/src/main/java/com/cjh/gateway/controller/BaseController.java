package com.cjh.gateway.controller;

import com.cjh.gateway.properties.WebMenuProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/gateway")
public class BaseController {

    @Autowired
    private WebMenuProperties webMenuProperties;


    @GetMapping("/go")
    private String gateWayForwardTest(){
        log.info("配置信息：{}",webMenuProperties.getMenu());
        return webMenuProperties.getMenu().toString();
    }
}
