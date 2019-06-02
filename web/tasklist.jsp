<%@ page import="java.util.List" %>
<%@ page import="model.TdlTask" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: johnraviv
  Date: 2019-05-06
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>


<html>
<head>
    <title>Task List</title>
    <%@ include file="header.jsp" %>
</head>
<body>
<style>
    .check {
        display: none;
        float: right;
        font-size: 20px;
    }

    .desc {
        text-align: center;
        font-size: 20px;
        border: 1px solid gray;
        padding: 20px 5px 20px 5px;
    }


</style>
<div data-role="content" class="task-list-container">
<h3>Add a new task:</h3>
        <form action ="${shit}/task/add" method="POST" data-ajax="false">
            <input type="text" name="taskTitle" placeholder="Title" >
            <textarea cols="40" rows="8" name="taskDescription" placeholder="Description"></textarea>
            <input type="text" name="email" style="display: none" value="<%= session.getAttribute("email")%>">
            <input type="submit" value="Add" class="form-btn">

        </form>
            <h3>Welcome <%= session.getAttribute("email")%></h3>

    <form>
            <input id="filter-for-listview" data-type="search" placeholder="Type to search...">
    </form>


    <ul data-role="listview" data-inset="true" data-filter="true" data-input="#filter-for-listview">
        <c:forEach var="task" items="${tasks}">
            <div data-role="collapsible" data-ajax="false">
                    <h4 class="task-title">${task.getTaskTitle()} <i class="fas fa-check check"></i></h4>
                    <p class="desc">${task.getTaskDescription()}</p>
                <br>
                <div class="task-btn">
                    <form action="${shit}/task/edit">
                        <input type="hidden" name="taskTitle" value="${task.getTaskTitle()}"/>
                        <input type="hidden" name="taskDescription" value="${task.getTaskDescription()}"/>
                        <input type="hidden" name="email" value="<%= session.getAttribute("email")%>">
                        <input type="hidden" name="id" value="${task.getId()}"/>
<%--                        <input type="hidden" name="TdlTask" value="${task}">TODO: ONLY SEND REQUERD--%>
                        <input type="submit" value="Edit" name="editBtn" />
                    </form>

                    <form action="${shit}/task/tasklist" method="post" data-ajax="false">
                        <input type="hidden" name="id" value="${task.getId()}"/>
                        <input type="hidden" name="email" value="<%= session.getAttribute("email")%>">
                        <input type="submit" value="Delete" name="deleteBtn" />
                    </form>

                    <form data-action="${shit}/task/done"  id="form_done" method="post" data-ajax="false">
                        <input type="hidden" name="id" value="${task.getId()}"/>
                        <button type="button" id="done-btn">Done!</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </ul>
</div>
<script>


</script>
<%@ include file="footer.jsp" %>

