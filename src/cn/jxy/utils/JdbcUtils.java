package cn.jxy.utils;

import javax.sql.StatementEvent;
import java.sql.*;

public class JdbcUtils {
    /*
    *主要用来数据库的链接
     */
       private JdbcUtils(){};
       static {
           System.out.println("只打印一次");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
          try {
              return DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf-8","root","21209zty");
          } catch (Exception e) {
            throw new RuntimeException();
          }


    }
    public static void close (Statement pre, Connection conn){
           close(null,pre,conn);
    }
    public static void close (ResultSet rs,Statement pre, Connection conn){
        try {
            if(rs !=null && !rs.isClosed())
            rs.close();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }finally {
            try {
                if(pre !=null && !pre.isClosed())
                pre.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    if(conn !=null && !conn.isClosed())
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }




}
