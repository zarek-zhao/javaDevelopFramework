package com.zarek.ioc.service.impl;

import com.zarek.ioc.service.SomeService;

/**
 * @author zhao
 * @date 2021/3/1 9:01
 */
public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl(){
        super();
        System.out.println("SomeServiceImpl无参数构造方法");
    }

    @Override
    public void doSome()
    {

        System.out.println("======业务方法doSome()=======");

    }
}
