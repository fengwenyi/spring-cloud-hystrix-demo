package com.fengwenyi.springcloudhystrixdemo.hystrixdemo.service.impl;

import com.fengwenyi.springcloudhystrixdemo.hystrixdemo.service.IDemoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-26
 */
@Service
public class DemoServiceImpl implements IDemoService {
    @Override
    @HystrixCommand(fallbackMethod = "helloWorldFallback")
    public String helloWorld() {
        try {
            Thread.sleep(50 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "threadIsolationFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
            },
            threadPoolKey = "hystrix-thread-pool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )
    public String threadIsolation(int id) {
        if (id == 1) {
            try {
                Thread.sleep(50 * 1000);
                return "error-" + id;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "success-" + id;
    }

    public String helloWorldFallback() {
        return "fallback";
    }

    public String threadIsolationFallback(int id) {
        return "fallback-" + id;
    }


}
