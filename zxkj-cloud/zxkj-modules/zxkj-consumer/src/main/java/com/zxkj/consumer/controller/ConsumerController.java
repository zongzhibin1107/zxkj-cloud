package com.zxkj.consumer.controller;

import com.zxkj.common.core.domain.R;
import com.zxkj.system.api.RemoteSystemTestService;
import com.zxkj.system.api.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    RemoteSystemTestService remoteSystemTestService;

    @Value("${zxkj.test}")
    private String value;


    @GetMapping("/consumer/test")
    public R<Test> test(){
        return remoteSystemTestService.test();
    }


    @GetMapping("/consumer/testget")
    public R<String> testget(){
        return R.ok(value + "-" );
    }
}
