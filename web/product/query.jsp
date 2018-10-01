<%--
  Created by IntelliJ IDEA.
  User: zty
  Date: 2018/9/9
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public.jspf"%>
<html>
  <head>
    <title>添加商品$</title>
  </head>
  <body>
     <form action="${shop}/servlet/ProductServlet" method="get">
    商品名:<<input type="text" name="keyword" /><br />
    <button type="submit">查询商品</button>
         <input type="hidden" name="type" value="query"/>
     </form>
     <hr />
     <c:if test="${!empty requestScope.productList}">
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
             <td>更新|<a href="${shop}/servlet/ProductServlet?id=${product.id}&type=delete">删除</a></td>
           </tr>
       </c:forEach>
     </table>
     </c:if>
  </body>
</html>
