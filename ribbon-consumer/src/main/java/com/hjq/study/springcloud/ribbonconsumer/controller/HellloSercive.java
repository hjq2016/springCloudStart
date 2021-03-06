package com.hjq.study.springcloud.ribbonconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HellloSercive {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://HJQ-SERVICE/hello",String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("Spend time : " + (end - start));
        return result;
    }

    public String helloFallback() {
        return "error";
    }
}
