package com.zarek;

import com.zarek.ioc.domain.School;
import com.zarek.ioc.domain.Student;
import com.zarek.ioc.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhao
 * @date 2021/3/1 9:20
 */
public class TestSpringApplicationContext {

    @Test
    public void testConstructorBeans()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = (Student) context.getBean("student1");
        System.out.println(student1);

    }

    @Test
    public void test5()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        School school = (School) context.getBean("school");
        System.out.println(school);
    }

    @Test
    public void test4()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Date date = (Date) context.getBean("myDate");
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY:MM:dd HH:mm:ss");
        String newDate = simpleDateFormat.format(date);
        System.out.println(newDate);

    }

    @Test
    public void test3()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);


    }

    @Test
    public void test2()
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

    @Test
    public void test1()
    {

        //spring配置文件在类路径下(classpath)
        String resource = "applicationContext.xml";
        //创建spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
        //从spring容器中获取对象，使用id
        SomeService service = (SomeService) ac.getBean("someService");
        service.doSome();

    }

}
