package test.cn.jxy.dao.impl; 

import cn.jxy.dao.impl.ProductDaoImpl;
import cn.jxy.model.Product;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.math.BigDecimal;
import java.util.List;

/** 
* ProductDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 17, 2018</pre> 
* @version 1.0 
*/ 
public class ProductDaoImplTest {

    private ProductDaoImpl daoImpl = null;

    @Before
public void before() throws Exception {
    System.out.println("在所有测试方法之前执行，一般用来初始化资源");
    daoImpl = new ProductDaoImpl();
} 

@After
public void after() throws Exception {
    System.out.println("在所有测试方法之后执行，一般用来释放资源");
    daoImpl = null;
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getById(int id) 
* 
*/ 
@Test
public void testGetById() throws Exception {
    System.out.println(daoImpl.getById(2));

}
@Test
public void testQueryByName() throws Exception {
    List<Product>productList = daoImpl.queryByName("");
    for (Product product:productList){
        System.out.println(product);
    }

}
    /**
* 
* Method: save(Product product) 
* 
*/ 
@Test
public void testSave() throws Exception {
    daoImpl.save(new Product("dededem模型",new BigDecimal(4.14),"ceshi///"));
} 

/** 
* 
* Method: update(Product product) 
* 
*/ 
@Test
public void testUpdate() throws Exception {
    Product product = new Product("dem模型",new BigDecimal(4.14),"ceshi///");
       product.setId(6);
       daoImpl.update(product);
} 

/** 
* 
* Method: delete(int id) 
* 
*/ 
@Test
public void testDelete() throws Exception {
    daoImpl.delete(4);
} 


} 
