package com.zarek.ioc.utils;

import com.zarek.ioc.servicetools.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhao
 * @date 2021/3/1 15:06
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;
    public MyInvocationHandler(Object target){
        super();
        this.target = target;
    }

    public MyInvocationHandler(){
        super();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {

        Object obj = null;
        //在方法之前输出日志
        ServiceTools.doLog();
        //执行目标方法，执行target对象的方法
        obj = method.invoke(target, args);
        //在方法之后，执行事务
        ServiceTools.doTrans();
        //返回目标方法的执行结果

        return obj;
    }
}
