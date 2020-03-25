package com.hjq.study.springcloud.eureku.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HellController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() throws InterruptedException {
        ServiceInstance instance = client.getLocalServiceInstance();
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleep " + sleepTime);
        Thread.sleep(sleepTime);
        logger.info("/hello,host:" + instance.getHost() + ", service_id" + instance.getServiceId());
        return "hello liuZhiPing";
    }
}
