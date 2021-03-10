package com.zarek.aop.service;

/**
 * @author zhao
 * @date 2021/3/1 14:44
 */
public interface SomeService {

    void doSome(String name,int age);
    String doOther(String name,int age);
    String doFirst(String name,int age);
    void doSecond();
}
