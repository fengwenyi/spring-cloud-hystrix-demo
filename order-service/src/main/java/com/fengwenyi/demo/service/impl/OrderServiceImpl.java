package com.fengwenyi.demo.service.impl;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.feign.IUserFeignClient;
import com.fengwenyi.demo.service.IOrderService;
import com.fengwenyi.demo.userapi.vo.UserResponseVo;
import com.fengwenyi.demo.vo.CreateOrderRequestVo;
import com.fengwenyi.javalib.convert.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Erwin Feng
 * @since 2021-03-17
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IUserFeignClient userFeignClient;

    @Override
    public ResultTemplate<Void> create(CreateOrderRequestVo requestVo) {

        ResultTemplate<UserResponseVo> result = userFeignClient.getUser(requestVo.getUid());
        log.info(JsonUtils.convertString(result));

        return ResultTemplate.success();
    }
}
