<%--
  Created by IntelliJ IDEA.
  User: zty
  Date: 2018/10/7
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="cn.jxy.model.User" %>
<%@include file="/public.jspf"%>
<html>
<head>
    <title>添加商品$</title>
</head>
<body>
此页面实现了登陆功能
    <%
        session.setAttribute("user",new User("admin","admin123"));
    %>
    <a href="${shop}/admin/index.jsp">访问后台首页</a>
</body>
</html>
