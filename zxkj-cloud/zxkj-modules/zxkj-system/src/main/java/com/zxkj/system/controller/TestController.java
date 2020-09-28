package com.zxkj.system.controller;

import com.zxkj.common.core.domain.R;
import com.zxkj.common.redis.service.RedisService;
import com.zxkj.system.api.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Autowired
    private RedisService redisService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public R<Test> test() {
        Test test = new Test();
        test.setAge(20);
        test.setName(port);
        redisService.setCacheObject("key1",test,2, TimeUnit.SECONDS);
        return R.ok(redisService.getCacheObject("key1"));
    }

    @GetMapping("/get")
    public R<String> get(String key)  {
        return R.ok(redisService.getCacheObject(key));
    }
}
