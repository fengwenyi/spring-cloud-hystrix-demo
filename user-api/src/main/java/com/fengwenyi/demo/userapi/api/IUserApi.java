package com.fengwenyi.demo.userapi.api;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.userapi.vo.UserRequestVo;
import com.fengwenyi.demo.userapi.vo.UserResponseVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author Erwin Feng
 * @since 2021-03-17
 */
@RequestMapping("/userApi")
public interface IUserApi {

    @GetMapping("/getUser")
    ResultTemplate<UserResponseVo> getUser(@RequestParam("uid") Integer uid);

    @PostMapping("/addUser")
    ResultTemplate<UserResponseVo> addUser(@RequestBody UserRequestVo requestVo);
}
