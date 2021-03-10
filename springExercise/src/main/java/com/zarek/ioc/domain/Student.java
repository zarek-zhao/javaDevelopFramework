package com.zarek.ioc.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhao
 * @date 2021/3/1 10:18
 */
@Component
public class Student {

    @Value("关羽")
    private String name;
    @Value("男")
    private String gender;
    @Value("55")
    private Integer age;

    public Student()
    {
        System.out.println("Student无参数的构造方法");
    }

    public Student(String name, String gender, Integer age)
    {
        System.out.println("Student有参数的构造方法");
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
