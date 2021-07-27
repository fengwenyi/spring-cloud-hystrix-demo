package com.fengwenyi.demo.service;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.userapi.vo.UserResponseVo;

/**
 * @author Erwin Feng
 * @since 2021-03-17
 */
public interface IUserService {

    ResultTemplate<UserResponseVo> getUser(Integer uid);

}
