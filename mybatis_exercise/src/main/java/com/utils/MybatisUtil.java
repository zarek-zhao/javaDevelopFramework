package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhao
 * @date 2021/2/28 19:00
 */
public class MybatisUtil {

    //定义SqlSessionFactory
    private static SqlSessionFactory factory= null;
    static {
    //使用静态块 创建一次SqlSessionFactory
        try {
            //读取配置文件
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactory对象
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            factory = null;
            e.printStackTrace();
        }

    }

    public static SqlSession getSqlSession(){
        SqlSession session = null;
        if(factory!=null){
            session = factory.openSession();
        }

        return session;

    }

}
