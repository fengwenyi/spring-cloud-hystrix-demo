package com.fengwenyi.demo.feign.fallback;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.feign.IUserFeignClient;
import com.fengwenyi.demo.userapi.vo.UserRequestVo;
import com.fengwenyi.demo.userapi.vo.UserResponseVo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Erwin Feng
 * @since 2021-03-24
 */
//@Component
@RequestMapping("/fallback")
public class UserFeignClientFallback implements IUserFeignClient {
    @Override
    public ResultTemplate<UserResponseVo> getUser(Integer uid) {
        return ResultTemplate.fail("feign调用接口失败");
    }

    @Override
    public ResultTemplate<UserResponseVo> addUser(UserRequestVo requestVo) {
        return ResultTemplate.fail("feign调用接口失败");
    }
}
