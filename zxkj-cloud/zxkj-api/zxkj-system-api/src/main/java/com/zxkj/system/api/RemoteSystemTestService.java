package com.zxkj.system.api;


import com.zxkj.common.core.constant.ServiceNameConstants;
import com.zxkj.common.core.domain.R;
import com.zxkj.system.api.domain.Test;
import com.zxkj.system.api.factory.RemoteSystemTestFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(contextId = "remoteSystemTestService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteSystemTestFallbackFactory.class)
public interface RemoteSystemTestService {

    @GetMapping("/test")
    public R<Test> test();

    @GetMapping("/get")
    public R<String> get(String key);
}
