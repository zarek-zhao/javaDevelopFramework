package com.zarek;

import com.zarek.aop.service.SomeService;
import com.zarek.aop.service.impl.SomeServiceImpl;
import com.zarek.ioc.utils.MyInvocationHandler;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

/**
 * @author zhao
 * @date 2021/3/1 14:59
 */
public class TestSpringAop {

    @Test
    public void testMyAspectjAopAfterThrowing(){
        String configLocation = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        SomeService someService = (SomeService) context.getBean("someServiceTarget");
        someService.doFirst("zhoa",12);
    }

    @Test
    public void testMyAspectjAopAround()
    {
        String configLocation = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        SomeService someService = (SomeService) context.getBean("someServiceTarget");
        someService.doFirst("hello",23);

    }

    @Test
    public void testMyAspectjAop()
    {

        String configLocation = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        SomeService proxy = (SomeService) context.getBean("someServiceTarget");
        proxy.doSome("zhao", 23);
        proxy.doOther("李白", 33);

    }

    @Test
    public void testMyInvocationHandler()
    {

        //创建代理对象
        SomeService target = new SomeServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(target);

        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);


        //通过代理对象执行业务方法，实现日志，事务的增强
        proxy.doSome("zhao", 23);
        proxy.doOther("李白", 45);
    }

    @Test
    public void test01()
    {
        SomeService someService = new SomeServiceImpl();
        someService.doOther("李白", 44);
        someService.doSome("zhao", 12);

    }


}
