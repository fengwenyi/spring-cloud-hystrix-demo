package com.fengwenyi.demo.feign;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.feign.fallback.UserFeignClientFallback;
import com.fengwenyi.demo.feign.fallbackfactory.UserFeignFallbackFactory;
import com.fengwenyi.demo.userapi.api.IUserApi;
import com.fengwenyi.demo.userapi.vo.UserResponseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Erwin Feng
 * @since 2021-03-17
 */
//@Component
//@FeignClient("user-service")
@FeignClient(name = "user-service"/*, fallback = UserFeignClientFallback.class*/, fallbackFactory = UserFeignFallbackFactory.class)
public interface IUserFeignClient extends IUserApi {

//    @GetMapping("/userApi/getUser")
//    ResultTemplate<UserResponseVo> getUser(@RequestParam("uid") Integer uid);

}
