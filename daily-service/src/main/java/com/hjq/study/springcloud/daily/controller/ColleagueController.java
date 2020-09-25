package com.hjq.study.springcloud.daily.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("colleague")
@Slf4j
public class ColleagueController {

    @GetMapping("beautifulGirl")
    public String name() throws InterruptedException {
        log.info("start" + System.currentTimeMillis());
        TimeUnit.SECONDS.sleep(3);
        log.info("end" + System.currentTimeMillis());
        return "zhangqin";
    }
}
