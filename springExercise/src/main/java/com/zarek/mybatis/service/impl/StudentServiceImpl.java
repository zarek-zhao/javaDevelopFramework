package com.zarek.mybatis.service.impl;

import com.zarek.mybatis.dao.StudentDao;
import com.zarek.mybatis.domain.Student;
import com.zarek.mybatis.service.StudentService;

import java.util.List;

/**
 * @author zhao
 * @date 2021/3/2 10:22
 */
public class StudentServiceImpl implements StudentService {

    /**
     * 定义Dao的引用类型的属性
     */
     private StudentDao studentDao;

    /**
     * 为了设值注入
     * @param studentDao
     */
    public void setStudentDao(StudentDao studentDao)
    {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student)
    {
        return studentDao.insertStudent(student);
    }

    @Override
    public int modifyStudent(Student student)
    {
        return studentDao.updateStudent(student);
    }

    @Override
    public int removeStudent(int id)
    {
        return studentDao.deleteStudentById(id);
    }

    @Override
    public Student findStudentById(int id)
    {
        return studentDao.selectStudentById(id);
    }

    @Override
    public List<Student> findAllStudent()
    {
        return studentDao.selectAllStudents();
    }
}
