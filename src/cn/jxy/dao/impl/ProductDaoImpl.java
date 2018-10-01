package cn.jxy.dao.impl;


import cn.jxy.model.Product;
import cn.jxy.utils.JdbcUtils;
import cn.jxy.utils.RowMapper;
import sun.applet.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl<Product> {



    //查询
    public Product getById(int id){
        String sql =   "SELECT id,name FROM product WHERE id = ?";
//1.获取connection链接对象
        Product product = null;

        return super.getById(sql,id,Product.class);
    }

    public int save(Product product){
        String sql =   "insert into product (name,price,remark) values (?,?,?)";
        return super.update(sql, new Object[]{product.getName(),product.getPrice(),product.getRemark()});

    }
    public int update(Product product){
        String sql =   "update product set name=?,price=?,remark=? where id=?";
//1.获取connection链接对象
        Connection conn = null;
        PreparedStatement pre = null;
        //2.执行SQL语句
        return super.update(sql, new Object[]{product.getName(),product.getPrice(),product.getRemark(),product.getId()});

    }
    public int delete(int id){
        String sql =   "delete from product where id=?";
//1.获取connection链接对象
        Connection conn = null;
        PreparedStatement pre = null;
        //2.执行SQL语句
        return super.update(sql, new Object[]{id});

    }


    public List<Product> queryByName(String keyword){
        String sql = "select * from product where name like ? ";

        return super.queryByName(sql,new Object[]{"%"+keyword+"%"},Product.class);
    }
}
