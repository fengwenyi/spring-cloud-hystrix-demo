package com.fengwenyi.demo.service.impl;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.service.IUserService;
import com.fengwenyi.demo.userapi.vo.UserResponseVo;
import org.springframework.stereotype.Service;

/**
 * @author Erwin Feng
 * @since 2021-03-17
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public ResultTemplate<UserResponseVo> getUser(Integer uid) {
        return ResultTemplate.success();
    }
}
