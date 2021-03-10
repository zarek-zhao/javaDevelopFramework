package com.zarek.ioc.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhao
 * @date 2021/3/1 11:24
 */

@Component
public class School {

    @Autowired
    @Qualifier("student")
    private Student student;
    @Value("江西省贵溪市第一中学")
    private String name;

    public School()
    {
    }


    public void setStudent(Student student)
    {
        this.student = student;
    }


    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "School{" +
                "student=" + student +
                ", name='" + name + '\'' +
                '}';
    }
}
