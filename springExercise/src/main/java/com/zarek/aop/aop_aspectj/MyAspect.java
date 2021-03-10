package com.zarek.aop.aop_aspectj;

/**
 * @author zhao
 * @date 2021/3/1 16:40
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Aspect:是aspectj框架的注解，表示当前类是切面类
 */
@Aspect
public class MyAspect {

    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))",throwing = "ex")
    public void myAfterThrowing(Throwable ex){
        //把异常发生的时间，位置，原因记录到数据库，日志文件等
        //可以在异常发生的，把异常信息通过短信，邮件发送给开发人员
        System.out.println("异常通知：在目标方法抛出异常时执行，异常原因："+ ex.getMessage());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY:MM:dd HH:mm:ss");
        System.out.println("异常通知：异常发生的时间："+ simpleDateFormat.format(new Date()));
    }

    @Before(value = "mypt()")
    public void beforeAop(){

        System.out.println("利用了切入点创建前置通知");

    }


    @Pointcut(value = "execution(* *..SomeServiceImpl.*(..))")
    private void mypt(){
    }



    /**
     * 环绕通知
     * @param pjp 连接点代表的对象
     * @return 连接点返回的参数
     * @throws Throwable
     */
    @Around(value = "mypt()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable
    {
        Object obj;
        //增强功能
        System.out.println("环绕通知:在目标方法之前执行的");
        //执行目标方法的调用，等同于method.invoke(target,args)
        obj = pjp.proceed();
        //增强功能
        System.out.println("环绕通知:在目标方法之后执行的");
        //返回目标方法的执行结果
        return obj;
    }




    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))", returning = "result")
    public void myAfterReturning(Object result)
    {
        //修改目标方法的执行结果
        if (result != null) {
            String s = (String) result;
            result = s.toUpperCase();
        }

        System.out.println("后置通知：在目标方法之后执行的功能增强，例如执行事务处理(切面)" + result);

    }


    /**
     * @Before:前置通知 属性；value 切入点表达式,表示切面执行的位置
     * 位置：方法的定义的上面
     */
    @Before(value = "execution(* com.zarek.aop.service.impl.SomeServiceImpl.*(..))")
    public void MyBefore()
    {
        //就是切面代码的功能，例如日志的输出，事务处理，一切的交叉业务逻辑
        System.out.println("前置通知：在目标方法之前先执行，例如输出日志");
    }


    /**
     * 通知方法：使用了通知注解修饰的方法
     * 通知方法可以有参数，但是参数不是任意
     * 1.JointPoint:表示连接点方法。
     *
     * @param jp
     */
    @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
    public void MyBefore2(JoinPoint jp)
    {

        //JointPoint能够获取到方法的定义，方法的参数等信息
        System.out.println("连接点的方法定义:" + jp.getSignature());
        System.out.println("连接点方法的参数个数：" + jp.getArgs().length);
        //方法参数的信息
        Object args[] = jp.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }

        //就是切面代码的功能，例如日志的输出
        System.out.println("前置通知：在目标方法之前先执行");
    }

}
