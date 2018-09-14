package cn.jxy.utils;

import java.sql.Connection;
import java.sql.DriverManager;

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
    private static Connection getConection() {
          try {
              return DriverManager.getConnection("jdbc:mysql://127.0.0.1:/3306/ztypaker","root","root");
          } catch (Exception e) {
            throw new RuntimeException();
          }


    }



    public static void main(String[] args){


            System.out.println(JdbcUtils.getConection());


    }
}
