package com.zarek;

import com.utils.MybatisUtil;
import com.zarek.ioc.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhao
 * @date 2021/2/28 14:26
 */
public class MybatisTest {

    @Test
    public void testUtil(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Object> studentList = sqlSession.selectList("com.zarek.dao.StudentDao.selectStudents");
        studentList.forEach(student-> System.out.println(student));
        sqlSession.close();

    }

    @Test
    public void testDelete() throws IOException
    {
        //1.加载mybatis配置文件到输入流
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4.执行session
        int id = 3;
        int rows = session.delete("com.zarek.dao.StudentDao.deleteStudent", id);
        //5.打印受到影响的条数
        System.out.println("删除的记录条数为:"+rows);
        //6.提交事务
        session.commit();
        //7.关闭session,释放连接
        session.close();
    }

    @Test
    public void testUpdate() throws IOException
    {

        //1.mybatis主配置文件
        String mybatis = "mybatis-config.xml";
        //2.加载主配置文件到文件流
        InputStream in = Resources.getResourceAsStream(mybatis);
        //3.创建SqlSessionFactory对象，为了获取SqlSession对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //4.创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //5.执行sqlSession语句
        Student s = new Student();
        s.setId(1);
        s.setEmail("");
        s.setAge(45);
        s.setName("");

        int rows = session.update("com.zarek.dao.StudentDao.updateStudent", s);

        //6.打印受影响的条数
        System.out.println("更新成功的条数:"+rows);

        //7.提交事务
        session.commit();

        //8.关闭session对象
        session.close();

    }

    @Test
    public void testStart() throws IOException
    {

        //1.mybatis主配置文件
        String config = "mybatis-config.xml";
        //2.读取配置文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactory对象，目的是获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //4.获取SqlSession,SqlSession能执行sql语句
        SqlSession session = sqlSessionFactory.openSession();
        //5.执行SqlSession的selectList()
        List<Student> studentList = session.selectList("com.zarek.dao.StudentDao.selectStudents");
        //6.循环输出查询结果
        studentList.forEach(student -> System.out.println(student));
        //7.关闭SqlSession,释放资源
        session.close();

    }

    @Test
    public void testInsertStudent() throws IOException
    {
        String config = "mybatis-config.xml";

        InputStream in = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = sqlSessionFactory.openSession();

        Student s = new Student();
        s.setName("张丽");
        s.setAge(23);
        s.setEmail("979252100@qq.com");
        s.setId(3);


        int rows = session.insert("com.zarek.dao.StudentDao.insertStudent", s);

        session.commit();

        System.out.println("增加记录的条数:" + rows);

        session.close();

    }

}
