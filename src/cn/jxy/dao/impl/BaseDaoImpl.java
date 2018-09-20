package cn.jxy.dao.impl;

import cn.jxy.model.Product;
import cn.jxy.utils.JdbcUtils;
import cn.jxy.utils.RowMapper;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl<T> {

   // public abstract T getRow(ResultSet rs)throws SQLException;

    protected T getById(String sql,Object id,Class<T> tClass){

        T model = null;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        //2.执行SQL语句
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setObject(1,id);

            rs = pre.executeQuery();
            if(rs.next()){

              model = tClass.newInstance();
              ResultSetMetaData metaData = rs.getMetaData();
              for(int i = 1;i <= metaData.getColumnCount();i++){
                  String colName = metaData.getColumnLabel(i);
                  System.out.println("列的名称为" + colName);
                  //根据列的名称，获取相应的属性名称
                  Field name = tClass.getDeclaredField(colName);
                  name.setAccessible(true);
                  name.set(model,rs.getObject(colName));
              }
            }
            return model;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
//3.释放资源
            JdbcUtils.close(rs,pre,conn);
        }
    }
//给子类使用，因此方法采用PROTECTED
    protected int update(String sql, Object[] param){
        //1.获取connection链接对象
        Connection conn = null;
        PreparedStatement pre = null;
        //2.执行SQL语句
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            for(int i = 0; i < param.length;i++) {
                pre.setObject(i+1,param[i]);
            }
            return pre.executeUpdate();//负责update,delate,save等操作
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
//3.释放资源
            JdbcUtils.close(pre,conn);
        }

    }
    public List<T> queryByName(String sql,Object[] param,Class<T> tClass){

        List<T> tList = new ArrayList<T>();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        //2.执行SQL语句
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            for(int i = 0; i < param.length;i++) {
                pre.setObject(i+1,param[i]);
            }

            rs = pre.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()){
//this永远指示的是当前调用的对象
                T model = (T) tClass.newInstance();
                for(int i = 1;i <= metaData.getColumnCount();i++){
                    String colName = metaData.getColumnLabel(i);
                    System.out.println("列的名称为" + colName);
                    //根据列的名称，获取相应的属性名称
                    Field name = tClass.getDeclaredField(colName);
                    name.setAccessible(true);
                    name.set(model,rs.getObject(colName));
                }
                tList.add(model);
            }
            return tList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
//3.释放资源
            JdbcUtils.close(rs,pre,conn);
        }
    }
}
