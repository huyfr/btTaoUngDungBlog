<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/06/2020
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Blog</title>
  </head>
  <body>
  <a href="/blog/create_blog">Create new blog</a>
  <h1>Blog</h1>
  <div>
    <c:if test="${message != null}">
      <p>${message}</p>
    </c:if>
  </div>
  <table border="1px solid black">
    <tr>
      <td>ID</td>
      <td>Title</td>
      <td>Content</td>
      <td>Edit</td>
      <td>Delete</td>
    </tr>
    <c:forEach var="blog" items="${blogList}">
      <tr>
        <td>${blog.id}</td>
        <td><a href="/blog/view_details/${blog.id}">${blog.title}</a></td>
        <td>${blog.content}</td>
        <td><a href="/blog/edit/${blog.id}">Edit</a></td>
        <td><a href="/blog/delete/${blog.id}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
