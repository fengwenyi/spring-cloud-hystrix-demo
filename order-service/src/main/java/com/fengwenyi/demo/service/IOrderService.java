package com.fengwenyi.demo.service;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.vo.CreateOrderRequestVo;

/**
 * @author Erwin Feng
 * @since 2021-03-17
 */
public interface IOrderService {

    ResultTemplate<Void> create(CreateOrderRequestVo requestVo);

}
