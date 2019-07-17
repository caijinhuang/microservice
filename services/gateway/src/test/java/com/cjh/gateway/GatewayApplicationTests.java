package com.cjh.gateway;

import com.cjh.gateway.properties.WebMenuProperties;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GatewayApplication.class, GatewayApplicationTests.class})
public class GatewayApplicationTests {

    @Autowired
    WebMenuProperties webMenuProperties;

    @Test
    public void contextLoads() {
        log.info("获取的属性，{}", webMenuProperties);
    }


}
