package com.zarek.aop.service.impl;

import com.zarek.aop.service.SomeService;

/**
 * @author zhao
 * @date 2021/3/1 14:56
 */
public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl()
    {
        System.out.println("SomeServiceTarget无参数的构造方法");
    }



    @Override
    public void doSome(String name,int age)
    {
//        ServiceTools.doLog();
        System.out.println("执行了业务方法doSome()");
//        ServiceTools.doTrans();
    }


    @Override
    public String doOther(String name,int age)
    {

//        ServiceTools.doLog();
        System.out.println("执行了业务方法doOther()");
//        ServiceTools.doTrans();
        return "abcd";
    }

    @Override
    public String doFirst(String name, int age)
    {
        System.out.println("执行了业务方法doFirst");
        return "doFirst";
    }

    @Override
    public void doSecond()
    {
        System.out.println("执行了业务方法doSecond"+(10/0));
    }


}
