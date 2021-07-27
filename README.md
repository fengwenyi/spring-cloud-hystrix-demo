# Spring Cloud Hystrix

## 版本问题

用最新版，不行。

测试版本对应

|名称|版本|
| --- | --- |
| | |

## fallback写法

### 一

```java
@FeignClient(name = "user-service", fallback = UserFeignClientFallback.class)
public interface IUserFeignClient extends IUserApi {
    
}
```

```java
@Component
@RequestMapping("/fallback") // 没有这个会报错，因为地址会重复
public class UserFeignClientFallback implements IUserFeignClient {
    @Override
    public ResultTemplate<UserResponseVo> getUser(Integer uid) {
        return ResultTemplate.fail("feign调用接口失败");
    }
}
```

### 二

```java
@FeignClient(name = "user-service", fallback = UserFeignClientFallback.class)
public interface IUserFeignClient {

    @GetMapping("/userApi/getUser")
    ResultTemplate<UserResponseVo> getUser(@RequestParam("uid") Integer uid);

}
```

```java
@Component
public class UserFeignClientFallback implements IUserFeignClient {
    @Override
    public ResultTemplate<UserResponseVo> getUser(Integer uid) {
        return ResultTemplate.fail("feign调用接口失败");
    }
}
```

## fallbackFactory

```java
@FeignClient(name = "user-service", fallbackFactory = UserFeignFallbackFactory.class)
public interface IUserFeignClient extends IUserApi {
}
```

```java
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

```