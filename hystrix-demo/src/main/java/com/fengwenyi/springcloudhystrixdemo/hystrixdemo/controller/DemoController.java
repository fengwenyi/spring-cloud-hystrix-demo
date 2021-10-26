package com.fengwenyi.springcloudhystrixdemo.hystrixdemo.controller;

import com.fengwenyi.springcloudhystrixdemo.hystrixdemo.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-26
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @RequestMapping("/hello-world")
    public String helloWorld() {
        return demoService.helloWorld();
    }

    @RequestMapping("/thread-isolation")
    public String threadIsolation() {
        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            String rs = demoService.threadIsolation(i);
            long endTime = System.currentTimeMillis();
            log.info("任务 {}，请求耗时：{} ms，响应={}", i, endTime - startTime, rs);
        }
        return "测试完成";
    }

}
