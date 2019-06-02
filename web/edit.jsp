<%@ page import="model.TdlTask" %><%--
  Created by IntelliJ IDEA.
  User: johnraviv
  Date: 2019-05-27
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="header.jsp" %>
<head>
    <title>Edit</title>
</head>
<body>
<%
    TdlTask task =  (TdlTask) session.getAttribute("task");

    %>

<form action ="tasklist" method="POST" id="update-form" data-ajax="false">
    <input type="text" name="taskTitle" placeholder="Title" value="${task.getTaskTitle()} ">
    <input type="text"  name="taskDescription" placeholder="Description" value="${task.getTaskDescription()}">
    <input type="hidden" name="id" value="${task.getId()}">
    <input type="text" name="email" style="display: none" value="<%= session.getAttribute("email")%>">
    <input type="submit" value="Update Task" name="updateBtn">

</form>


<%@ include file="footer.jsp" %>
