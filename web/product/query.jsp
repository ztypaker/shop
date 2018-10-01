<%--
  Created by IntelliJ IDEA.
  User: zty
  Date: 2018/9/9
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>添加商品$</title>
  </head>
  <body>
     <form action="/shop/servlet/ProductServlet" method="get">
    商品名:<<input type="text" name="keyword" /><br />
    <button type="submit">查询商品</button>
     </form>
     <hr />
     <table border="1" width="600">
       <tr>
         <th>编号</th>
         <th>名称</th>
         <th>价格</th>
         <th>备注</th>
         <th>操作</th>
       </tr>
       <!--采用jstl的方式来迭代数据-->
       <c:forEach items="${requestScope.productList}" var="product" varStatus="num">
           <tr>
             <td>${num.count}</td>
             <td>${product.name}</td>
             <td>${product.price}</td>
             <td>${product.remark}</td>
             <td>更新|删除</td>
           </tr>
       </c:forEach>
     </table>
  </body>
</html>
