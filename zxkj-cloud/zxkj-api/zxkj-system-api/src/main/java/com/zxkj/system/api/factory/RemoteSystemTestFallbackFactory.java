package com.zxkj.system.api.factory;

import com.zxkj.common.core.domain.R;
import com.zxkj.system.api.RemoteSystemTestService;
import com.zxkj.system.api.domain.Test;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 测试服务降级
 */
@Component
@Slf4j
public class RemoteSystemTestFallbackFactory implements FallbackFactory<RemoteSystemTestService> {


    @Override
    public RemoteSystemTestService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteSystemTestService() {
            @Override
            public R<Test> test() {
                return R.fail("调用test方法失败:" + throwable.getMessage());
            }

            @Override
            public R<String> get(String key) {
                return R.fail("调用get方法失败:" + throwable.getMessage());
            }
        };
    }
}
