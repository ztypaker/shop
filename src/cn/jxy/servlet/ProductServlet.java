package cn.jxy.servlet;

import cn.jxy.model.Product;
import cn.jxy.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/servlet/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductServiceImpl productService = new ProductServiceImpl();
    public ProductServlet() {
        super();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("处理post请求");
        String type = request.getParameter("type");
//        if(type.equals("save")){
//
//        }
//        else if(type.equals("query")){
//
//        }else if(type.equals("delete")){
//
//        }
        //通过反射方式调用方法
        try {
            Method method = this.getClass().getMethod(type,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理get请求");
        doPost(request,response);
    }
    public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setPrice(new BigDecimal(request.getParameter("price")));
        product.setRemark(request.getParameter("remark"));
        //调用业务逻辑
        productService.save(product);
        //返回到目标页面(从定向）
        response.sendRedirect(request.getContextPath() + "/product/query.jsp");
    }
   public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取前端数据
        String keyword =request.getParameter("keyword");
        //调用业务逻辑
        List<Product> productList = productService.queryByName(keyword);
        //返回到目标页面
        //productlist在目标页面显示应该采用request
        request.setAttribute("productList",productList);
        //通过转发来完成servlet与jsp页面共享(默认添加了工程名）
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/query.jsp");
        dispatcher.forward(request,response);
        //response.sendRedirect("/shop/product/query.jsp");
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        System.out.println("删除id"+id);
    }
}
