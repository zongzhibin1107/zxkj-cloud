package com.zxkj.system.controller;

import com.zxkj.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/test")
    public Test test() {
        Test test = new Test();
        test.setAge(20);
        test.setName("张三");
        redisService.setCacheObject("key1",test,2, TimeUnit.SECONDS);
        return redisService.getCacheObject("key1");
    }

    @GetMapping("/get")
    public Object get(String key)  {
        return redisService.getCacheObject(key);
    }
}
