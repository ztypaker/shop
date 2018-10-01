package test.cn.jxy.service.impl; 

import cn.jxy.model.Product;
import cn.jxy.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.math.BigDecimal;

/** 
* ProductServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 24, 2018</pre> 
* @version 1.0 
*/ 
public class ProductServiceImplTest {
    private ProductServiceImpl daoImpl = null;
@Before
public void before() throws Exception {
    System.out.println("在所有测试方法之前执行，一般用来初始化资源");
    daoImpl = new ProductServiceImpl();
} 

@After
public void after() throws Exception {
    System.out.println("在所有测试方法之后执行，一般用来释放资源");
    daoImpl = null;
} 

/** 
* 
* Method: getById(int id) 
* 
*/ 
@Test
public void testGetById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: save(Product product) 
* 
*/ 
@Test
public void testSave() throws Exception {
    daoImpl.save(new Product("ddss",new BigDecimal(4.14),"ceshi///"));
} 

/** 
* 
* Method: update(Product product) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(int id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: queryByName(String keyword) 
* 
*/ 
@Test
public void testQueryByName() throws Exception { 
//TODO: Test goes here... 
} 


} 
