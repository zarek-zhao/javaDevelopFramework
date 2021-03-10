package com.zarek.mybatis.domain;

/**
 * @author zhao
 * @date 2021/3/2 10:06
 */
public class Student {

    private Integer id;
    private String name;
    private Integer age;

    public Student()
    {
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
