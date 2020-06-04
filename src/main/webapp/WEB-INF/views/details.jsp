<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/06/2020
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Details</title>
</head>
<body>
<h1>Chi tiet blog</h1>
<table border="1px solid black">
    <tr>
        <td>ID</td>
        <td>${blog.id}</td>
    </tr>
        <tr>
            <td>Title</td>
            <td>${blog.title}</td>
        </tr>
    <tr>
        <td>Content</td>
        <td><textarea name="content" id="" cols="30" rows="10" disabled>${blog.content}</textarea></td>
    </tr>
</table>
</body>
</html>
