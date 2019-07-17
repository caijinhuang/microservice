package com.cjh.study.producerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProducerServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProducerServerApplication.class, args);
    }

}
