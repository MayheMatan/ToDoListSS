<%--
  Created by IntelliJ IDEA.
  User: johnraviv
  Date: 2019-05-06
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<c:set var="shit" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/Servlet" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; minimum-scale=1.0; user-scalable=no; target-densityDpi=device-dpi"/>
    <%--custom styles--%>
    <link href="http://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">--%>

    <%--Jquery mobile--%>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/228beed06a.js"></script>
</head>
<style>
    .main-logo {
        text-align: center;
    }
    body {
        font-family: 'Raleway', sans-serif;
    }


</style>
<div data-role="page" data-theme="b">
    <div data-role="header" class="main-logo">
        <img src="${pageContext.request.contextPath}/assets/Logo.png" width="225" height="125">
    <div data-role="navbar" data-ajax="false">
        <ul>

            <li><a href="${shit}/index" class="ui-btn-active">Home</a></li>
<%--            TODO: Make all the URLs here in one file so it will be resusable in the views. --%>
            <li><a href="${shit}/user/login">Log In</a></li>
            <li><a href="${shit}/user/register">Register</a></li>
            <li><a href="${shit}/about">About</a></li>

        </ul>
    </div><!-- /navbar -->

    </div><!-- /header -->