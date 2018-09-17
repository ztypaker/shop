package cn.jxy.dao.impl;


import cn.jxy.model.Product;
import cn.jxy.utils.JdbcUtils;
import sun.applet.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl {

//    public static void main(String[] args) {
//        int i=0;
//        ProductDaoImpl daoImpl = new ProductDaoImpl();
//       // daoImpl.save(new Product("demom模型",3.14,"ceshi///"));
//
////        Product product = new Product("demom模型",3.19,"ceshi///");
////        product.setId(2);
////        daoImpl.update(product);
//
////        daoImpl.delete(4);
//        System.out.println(daoImpl.getById(1));
//    }

    //查询
    public Product getById(int id){
        String sql =   "SELECT * FROM product WHERE id = ?";
//1.获取connection链接对象
        Product product = null;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        //2.执行SQL语句
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1,id);

            rs = pre.executeQuery();
            if(rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setRemark(rs.getString("remark"));
            }
                return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
//3.释放资源
            JdbcUtils.close(rs,pre,conn);
        }
    }
    public int save(Product product){
        String sql =   "insert into product (name,price,remark) values (?,?,?)";
//1.获取connection链接对象
        Connection conn = null;
        PreparedStatement pre = null;
        //2.执行SQL语句
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1,product.getName());
            pre.setDouble(2,product.getPrice());
            pre.setString(3,product.getRemark());
            return pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
//3.释放资源
            JdbcUtils.close(pre,conn);
        }

    }
    public int update(Product product){
        String sql =   "update product set name=?,price=?,remark=? where id=?";
//1.获取connection链接对象
        Connection conn = null;
        PreparedStatement pre = null;
        //2.执行SQL语句
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1,product.getName());
            pre.setDouble(2,product.getPrice());
            pre.setString(3,product.getRemark());
            pre.setInt(4,product.getId());
            return pre.executeUpdate();//负责update,delate,save等操作
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
//3.释放资源
            JdbcUtils.close(pre,conn);
        }

    }
    public int delete(int id){
        String sql =   "delete from product where id=?";
//1.获取connection链接对象
        Connection conn = null;
        PreparedStatement pre = null;
        //2.执行SQL语句
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1,id);
            return pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
//3.释放资源
            JdbcUtils.close(pre,conn);
        }

    }
}
