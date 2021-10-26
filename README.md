# Spring Cloud Hystrix Demo

## 版本问题

用最新版，不行。

测试版本对应

|名称|版本|
| --- | --- |
| spring-boot | 2.0.3.RELEASE |
| spring-cloud | Finchley.RELEASE |

## hystrix 与 feign

**IUserApi**

```java
@RequestMapping("/userApi")
public interface IUserApi {

    @GetMapping("/getUser")
    ResultTemplate<UserResponseVo> getUser(@RequestParam("uid") Integer uid);

    @PostMapping("/addUser")
    ResultTemplate<UserResponseVo> addUser(@RequestBody UserRequestVo requestVo);
}
```

### fallback用法示例

#### 第一种写法，继承API

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

#### 第二种写法，不继承API

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

### fallbackFactory用法示例

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

## @HystrixCommand注解

```java
public class Demo {
    
    @HystrixCommand(
            fallbackMethod = "fallbackMethod",
            ignoreExceptions = {},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
            },
            threadPoolKey = "hystrixDemoThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            },
            observableExecutionMode = ObservableExecutionMode.EAGER,
            defaultFallback = "")
    public void create() {

    }
    
}
```

@HystrixProperty


