<%--
  Created by IntelliJ IDEA.
  User: johnraviv
  Date: 2019-05-06
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="header.jsp" %>
<head>
    <title>About</title>


    <style>
        .about-page {
            font-family: 'Raleway', sans-serif;
        }
        .about-us {
            color: #000000;

        }
        .about-icons {
            padding: 100px 0 100px 0;
            font-size: 50px;
            text-align: center;
        }
        .featurette {
            border-bottom: 1px solid white;
        }

    </style>
</head>
<body>
<script>

    $(document).on('mobileinit', function () {
        $.mobile.ignoreContentEnabled = true;
    });
</script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<div data-enhance="false" data-role="content" class="about-page">


    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container-fluid about-us">
            <h1 class="display-3 text-center">About Us</h1>
            <p class="text-center">The people behind this project.</p>
        </div>
    </div>


    <div class="container">
        <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-4">
                <h2>Yonathan Raviv</h2>
                <p>Web Developer, UI/UX Designer. </p>
                <p><a class="btn btn-light" href="https://www.linkedin.com/" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>Koby Korsia</h2>
                <p>Java Developer, Native Android developer. </p>
                <p><a class="btn btn-light" href="https://www.linkedin.com/" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>Matan fried</h2>
                <p>MASTOL MASTOL!!!!</p>
                <p><a class="btn btn-light" href="https://www.linkedin.com/" role="button">View details &raquo;</a></p>
            </div>
        </div>

        <hr>

    </div> <!-- /container -->

    <!-- START THE FEATURETTES -->
<div class="container">
    <hr class="featurette-divider">
    <h2 class="text-center">How we build it</h2>
    <br>
    <br>

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">Java EE <span class="text-muted">To connect and manage a MySql server.</span></h2>
            <p class="lead">An MVC project build with Java using Hibernet, Servlets and Classes to read/write data to our MySql DB.</p>
        </div>
        <div class="col-md-5 about-icons">

             <i class="fas fa-laptop-code"></i>

        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7 order-md-2">
            <h2 class="featurette-heading">HTML/CSS/JavaScript <span class="text-muted">So it will look good!</span></h2>
            <p class="lead">To make our app look beautiful, dynamic and interactive. </p>
        </div>
        <div class="col-md-5 order-md-1 about-icons">
            <i class="fab fa-html5"></i> & <i class="fab fa-css3-alt"></i>
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">JqueryMobile and Bootstrap4 <span class="text-muted">For responsivness.</span></h2>
            <p class="lead">The frameworks that makes this app mobile friendly and functional across all devices.</p>
        </div>
        <div class="col-md-5 about-icons">
            <i class="fab fa-bootstrap"></i>
        </div>
    </div>

    <hr class="featurette-divider">
</div>
    <!-- /END THE FEATURETTES -->



</div>
<%@ include file="footer.jsp" %>

