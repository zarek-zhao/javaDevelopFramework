package com.zarek.mybatis.dao;

import com.zarek.mybatis.domain.Student;

import java.util.List;

/**
 * @author zhao
 * @date 2021/3/2 10:07
 */
public interface StudentDao {

    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudentById(int id);

    Student selectStudentById(int id);
    List<Student> selectAllStudents();

}
