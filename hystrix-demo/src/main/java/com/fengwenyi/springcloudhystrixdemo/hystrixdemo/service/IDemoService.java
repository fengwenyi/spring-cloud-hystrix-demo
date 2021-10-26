package com.fengwenyi.springcloudhystrixdemo.hystrixdemo.service;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-26
 */
public interface IDemoService {

    String helloWorld();

    String threadIsolation(int id);
}
