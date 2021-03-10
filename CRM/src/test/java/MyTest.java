import com.zarek.setting.domain.Student;
import com.zarek.utils.DateTimeUtil;
import com.zarek.utils.UUIDUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @date 2021/2/27 18:30
 */
public class MyTest {

    @Test
    public void myTest1(){
        System.out.println(DateTimeUtil.currentTime());
        System.out.println(UUIDUtil.getUUID());
    }


    @Test
    public void JDBCTest(){


        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //注册 mysql 驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据的基本信息 url ，username，password
            String url = "jdbc:mysql://localhost:3306/springdb";
            String username = "root";
            String password = "123456";
            //创建连接对象
            conn = DriverManager.getConnection(url, username, password);
            //保存查询结果
            List<Student> stuList = new ArrayList<>();
            //创建 Statement, 用来执行 sql 语句
            stmt = conn.createStatement();
            //执行查询，创建记录集，
            rs = stmt.executeQuery("select * from student");
            while (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getString("id"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getString("age"));
                //从数据库取出数据转为 Student 对象，封装到 List 集合
                stuList.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                if (rs != null) ;
                {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

}
