package cn.jxy.service.impl;

import cn.jxy.dao.impl.ProductDaoImpl;
import cn.jxy.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ProductServiceImpl {
    //业务逻辑层依赖数据访问层
    private ProductDaoImpl productDao = new ProductDaoImpl();
    //查询
    public Product getById(int id){
     return productDao.getById(id);
    }

    public int save(Product product){

        return productDao.save(product);

    }
    public int update(Product product){

        return productDao.update(product);
    }
    public int delete(int id){

       return productDao.delete(id);

    }


    public List<Product> queryByName(String keyword){
        return productDao.queryByName(keyword);
    }
}
