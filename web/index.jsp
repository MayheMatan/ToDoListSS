<%--
  Created by IntelliJ IDEA.
  User: johnraviv
  Date: 2019-05-01
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Home Page</title>

    <%@ include file="header.jsp" %>
</head>

<body>
    <style>

        .content-center {
            display: flex;
            justify-content: center;
            text-align: center;
        }
        .main-headlines {
            font-size: 52px;
            font-weight: bold;
            color: #1D212B;
        }
        .negative {
            color: #1D212B;
            font-size: 26px;
        }
        .jumbotron {
            background-image: url("${pageContext.request.contextPath}/assets/Heroback.png");
            background-repeat: no-repeat;
            background-size: cover;
            padding-bottom: 150px;
            opacity: 0.7;
        }
    </style>

<div data-role="content">
<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron content-center" >
    <div class="container">
        <h1 class="main-headlines">DO-It!</h1>
        <p class="negative">This is the best To do list that you will ever need!</p>
        <p><a class="btn" href="#" role="button">Learn more &raquo;</a></p>
    </div>
</div>

<div class="container-hero">
    <!-- Example row of columns -->
    <div class="ui-grid-b content-center">
        <div class="ui-block-a">
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="ui-block-b">
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="ui-block-c">
            <h2>Heading</h2>
            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
            <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
        </div>
    </div>

    <hr>

</div> <!-- /container -->
</div>


<%@ include file="footer.jsp" %>

