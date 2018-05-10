<%--
  Created by IntelliJ IDEA.
  User: hd48552
  Date: 2018/5/10
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test2</title>
    <%--多个请求对应同一个servlet 方案二--%>
    <%-- 每个请求的访问名以“.do”结尾，同时servlet配置的访问名为“*.do” 通过servletpath区分不同的请求--%>
</head>
<body>
    <a href="add.do">add</a>
    <a href="delete.do">delete</a>
    <a href="query.do">query</a>
</body>
</html>
