<%--
  Created by IntelliJ IDEA.
  User: hd48552
  Date: 2018/5/10
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test1</title>
    <%--多个请求对应一个servlet 方案一--%>
    <%-- 每个请求都链接到同一个servlet，通过method参数来区分不同的请求 --%>
</head>
<body>
    <a href="/Test1Servlet?method=add ">add</a>
    <a href="/Test1Servlet?method=delete ">delete</a>
    <a href="/Test1Servlet?method=update ">update</a>
    <a href="/Test1Servlet?method=query ">query</a>
</body>
</html>
