package com.hjq.study.springcloud.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HellloSercive hellloSercive;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        //return restTemplate.getForEntity("http://HJQ-SERVICE/hello", String.class).getBody();
        return hellloSercive.helloService();
    }
}
