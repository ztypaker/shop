<%--
  Created by IntelliJ IDEA.
  User: zty
  Date: 2018/10/7
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public.jspf"%>
<html>
<head>
    <title>g更新商品$</title>
</head>
<body>
<!-- name                varchar(20),
price               decimal(8,2),
pic                 varchar(100),
remark              longtext,
date                timestamp default CURRENT_TIMESTAMP,
  -->
<form action="${shop}/servlet/ProductServlet" method="post">
    商品名:<<input type="text" name="name" value="${requestScope.product.name}"/><br />
    价格:<<input type="text" name="price" value="${requestScope.product.price}"/><br />
    备注:<<input type="text" name="remark" value="${requestScope.product.remark}"/><br />
    <button type="submit">更新商品</button>
    <input type="hidden" name="type" value="update"/>
    <input type="hidden" name="id" value="${requestScope.product.id}"/>
</form>
</body>
</html>

