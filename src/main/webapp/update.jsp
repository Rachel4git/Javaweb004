<%--
  Created by IntelliJ IDEA.
  User: hd48552
  Date: 2018/5/11
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
  <form action="update.do?" name="update">
      <%--使用隐藏域传递旧的数据--%>
      <input type="hidden" name="id" value="<%= request.getParameter("id")%>">
      <input type="hidden" name="zonename" value="<%= request.getParameter("zonename")%>">
      <input type="hidden" name="zonearea" value="<%= request.getParameter("zonearea")%>">

      id: <%= request.getParameter("id")%>
      <br>
      <%--更新为：--%>
      <%--<input type="text" name="idnew">--%>
      <%--<br>--%>
      zonename: <%= request.getParameter("zonename")%>
      <br>
      更新为：
      <input type="text" name="zonenamenew">
      <br>
      zonearea: <%= request.getParameter("zonearea")%>
      <br>
      更新为：
      <input type="text" name="zoneareanew">
      <br>
      <input type="submit" name="submitupdate">
  </form>
</body>
</html>
