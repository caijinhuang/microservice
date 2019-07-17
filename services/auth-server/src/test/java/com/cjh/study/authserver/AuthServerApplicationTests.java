package com.cjh.study.authserver;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@Log4j2
public class AuthServerApplicationTests extends BaseTest {

    @Value("${test.randomNum}")
    private String num;
    @Value("${test.name}")
    private String name;

    @Test
    public void contextLoads() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/base")).andReturn();
        // 解决中文乱码
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info("属性值={}", num);
        log.info("配置中心属性test.name={}", name);
        log.info(result.getResponse().getContentAsString());
    }

    @Test
    public void cloudPost() {
        String str = restTemplate.getForObject("http://gateway/auth/base", String.class);
        log.info("返回结果:{}", str);
    }

}
