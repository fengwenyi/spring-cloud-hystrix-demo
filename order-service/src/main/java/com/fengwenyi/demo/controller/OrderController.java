package com.fengwenyi.demo.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.service.IOrderService;
import com.fengwenyi.demo.vo.CreateOrderRequestVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng
 * @since 2021-03-17
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/create")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public ResultTemplate<Void> create(@RequestBody CreateOrderRequestVo requestVo) {
        log.info("{}", 1 / 0);
        return orderService.create(requestVo);
    }

    private ResultTemplate<Void> fallbackMethod(CreateOrderRequestVo requestVo) {
        return ResultTemplate.fail("服务熔断");
    }

}
