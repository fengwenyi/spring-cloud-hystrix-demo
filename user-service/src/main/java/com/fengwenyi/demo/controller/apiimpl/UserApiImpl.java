package com.fengwenyi.demo.controller.apiimpl;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.service.IUserService;
import com.fengwenyi.demo.userapi.api.IUserApi;
import com.fengwenyi.demo.userapi.vo.UserRequestVo;
import com.fengwenyi.demo.userapi.vo.UserResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng
 * @since 2021-03-17
 */
@RestController
public class UserApiImpl implements IUserApi {

    @Autowired
    private IUserService userService;

    @Override
    public ResultTemplate<UserResponseVo> getUser(Integer uid) {
        return userService.getUser(uid);
    }

    @Override
    public ResultTemplate<UserResponseVo> addUser(UserRequestVo requestVo) {
        return ResultTemplate.fail();
    }
}
