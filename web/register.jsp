<%--
  Created by IntelliJ IDEA.
  User: johnraviv
  Date: 2019-05-06
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <%@ include file="header.jsp" %>

</head>
<body>
<div class="container-login" data-role="content">

    <form action="registerNewUser" method="POST" data-ajax="false">
        <input type="text" name="userName" placeholder="User Name">
        <input type="password" name="password" placeholder="Password">
        <input type="email" name="email" placeholder="Email">

        <input type="submit" value="Register">
        <p>registered? <a href="login">go to login page</a></p>
    </form>
</div>
<%@ include file="footer.jsp" %>

