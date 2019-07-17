package com.cjh.study.authserver;


import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AuthServerApplication.class})
public class BaseTest {

    MockMvc mvc;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebApplicationContext context;


    @Before
    public void setUp() {
        // 单个控制器单独测试。但是读不到具体配置
//        mvc = MockMvcBuilders.standaloneSetup(new BaseController()).build();
        // 使用上下文启动好的控制器，可以正常使用配置属性
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
}
