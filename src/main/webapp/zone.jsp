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
<form method="get" action="query.do">
    ID：<input type="text" name="id">
    <br>
    zone name <input type="text" name="zonename">
    <br>
    zone area <input type="text" name="zonearea">
    <br>
    <input type="submit" name="query">
    <a href="add.do">insert</a>
</form>


<table cellspacing="0" cellpadding="1" border="2">

    <%
        List<Zone> lsz = (List<Zone>) request.getAttribute("zonelist");
        if(lsz!=null && lsz.size()>0){
    %>
    <th>
    <td>id</td>
    <td>zone name</td>
    <td>zone area</td>

    </th>

    <%
        for(Zone z : lsz){
     %>
        <tr>
            <td> <%= z.getId()%></td>
            <td> <%= z.getZoneName()%></td>
            <td> <%= z.getZoneArea()%></td>
            <td> <a href="update.do" name="update">update</a> </td>
            <td> <a href="delete.do" name="delete">delete</a></td>
        </tr>

     <%
        }
     }
    %>
</table>
</body>
</html>
