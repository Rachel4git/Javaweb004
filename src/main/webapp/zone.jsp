<%@ page import="main.atrachel.DTO.Zone" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hd48552
  Date: 2018/5/10
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>zone</title>
</head>
<body>
<%--表单 获取用户查询输入--%>
<%--将查询请求参数发送到 query.do 对应的servlet，由该servlet处理请求--%>
<form method="get" action="query.do">
    ID：<input type="text" name="id">
    <br>
    zone name <input type="text" name="zonename">
    <br>
    zone area <input type="text" name="zonearea">
    <br>
    <input type="submit" name="query" value="query">
    <a href="insertzone.jsp">insert</a>
</form>

<%--表格显示查询结果--%>
<table cellspacing="0" cellpadding="1" border="2">

    <%
        //query.do对应的servlet将查询结果放到request中，通过request.getAttribute可以获取该结果
        List<Zone> lsz = (List<Zone>) request.getAttribute("zonelist");
        //如果查询结果不为空，则对结果进行遍历显示到表格中
        if(lsz!=null && lsz.size()>0){
    %>

    <th>id</th>
    <th>zone name</th>
    <th>zone area</th>
    <th>delete</th>
    <th>update</th>



    <%
        for(Zone z : lsz){
     %>
        <tr>
            <td> <%= z.getId()%></td>
            <td> <%= z.getZoneName()%></td>
            <td> <%= z.getZoneArea()%></td>
            <td>
                <a href="delete.do?id=<%= z.getId()%>&zonename=<%= z.getZoneName()%>&zonearea=<%= z.getZoneArea()%>" name="delete">delete</a>
            </td>
            <td>
                <a href="update.jsp?id=<%= z.getId()%>&zonename=<%= z.getZoneName()%>&zonearea=<%= z.getZoneArea()%>" name="update">update</a>
            </td>
        </tr>

     <%
        }
     }
    %>
</table>
</body>
</html>
