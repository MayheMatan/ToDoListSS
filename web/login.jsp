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
    <title>log In</title>

    <%@ include file="header.jsp" %>
</head>
<body>

<div class="container-login" data-role="content">

    <form action ="login" method="POST" data-ajax="false">
        <input type="email" name="email" id="email" placeholder="Email" >
        <input type="password" name="password" id="password" placeholder="Password">
        <input type="submit" value="log In" class="form-btn">


        <p>Not registered? <a href="register">Create an account</a></p>
    </form>

</div>



<%@ include file="footer.jsp" %>

