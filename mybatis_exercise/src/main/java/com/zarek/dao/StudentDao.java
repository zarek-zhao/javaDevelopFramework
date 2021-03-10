package com.zarek.dao;

import com.zarek.ioc.domain.Student;

import java.util.List;

/**
 * @author zhao
 * @date 2021/2/28 14:08
 */
public interface StudentDao {

    int deleteStudentById(int id);

    /**
     * 查询学生表中的所有信息
     * @return 学生对象的集合
     */
    List<Student> selectStudents();

    /**
     * 插入一条学生记录
     * @return  返回受影响的条数
     */
    int insertStudent(Student student);

    /**
     * 更新一条学生记录
     * @return  返回受影响的条数
     */
    int updateStudent(Student student);

}
