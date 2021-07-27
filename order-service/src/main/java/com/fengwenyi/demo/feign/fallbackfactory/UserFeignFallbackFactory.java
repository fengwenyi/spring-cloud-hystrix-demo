package com.fengwenyi.demo.feign.fallbackfactory;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.feign.IUserFeignClient;
import com.fengwenyi.demo.userapi.vo.UserRequestVo;
import com.fengwenyi.demo.userapi.vo.UserResponseVo;
//import org.springframework.cloud.openfeign.FallbackFactory;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Erwin Feng
 * @since 2021-03-24
 */
@Component
public class UserFeignFallbackFactory implements FallbackFactory<IUserFeignClient> {
    @Override
    public IUserFeignClient create(Throwable cause) {

        return new IUserFeignClient() {
            @Override
            public ResultTemplate<UserResponseVo> getUser(Integer uid) {
                return ResultTemplate.fail("feign调用接口失败");
            }

            @Override
            public ResultTemplate<UserResponseVo> addUser(UserRequestVo requestVo) {
                return ResultTemplate.fail("feign调用接口失败");
            }
        };
    }
}
