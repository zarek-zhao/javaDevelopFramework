package com.zarek.mybatis.service;

import com.zarek.mybatis.domain.Student;

import java.util.List;

/**
 * @author zhao
 * @date 2021/3/2 10:21
 */
public interface StudentService {

    int addStudent(Student student);

    int modifyStudent(Student student);

    int removeStudent(int id);

    Student findStudentById(int id);

    List<Student> findAllStudent();

}
