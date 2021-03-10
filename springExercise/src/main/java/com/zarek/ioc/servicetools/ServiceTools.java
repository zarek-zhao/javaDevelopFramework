package com.zarek.ioc.servicetools;

/**
 * @author zhao
 * @date 2021/3/1 15:01
 */
public class ServiceTools {


    public static void doLog(){
        System.out.println("非业务功能，日志功能，在方法开始时输出日志");
    }

    public static void doTrans(){
        System.out.println("非业务功能，事务功能，在业务方法执行之后，加入事务");
    }
}
