<%--
  Created by IntelliJ IDEA.
  User: zty
  Date: 2018/9/9
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>添加商品$</title>
  </head>
  <body>
        <!-- name                varchar(20),
  price               decimal(8,2),
  pic                 varchar(100),
  remark              longtext,
  date                timestamp default CURRENT_TIMESTAMP,
          -->
        <form action="/shop/servlet/ProductServlet" method="post">
            商品名:<<input type="text" name="name" /><br />
            价格:<<input type="text" name="price" /><br />
            备注:<<input type="text" name="remark" /><br />
            <button type="submit">添加商品</button>
        </form>
  </body>
</html>
