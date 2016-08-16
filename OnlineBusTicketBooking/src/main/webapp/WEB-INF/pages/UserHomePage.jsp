<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <title>Online Bus Ticket Booking</title>

        <!-- Bootstrap Core CSS -->
        <link href="styles/bootstrap.min.css" rel="stylesheet">

        <!-- Theme CSS -->
        <link href="styles/freelancer.min.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="styles/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css"> 
    </head>
    <style>
        .body{
            background : url("images/bus1.jpg");
        }
        .carousel-inner img {
            width: 100%; /* Set width to 100% */
            margin: auto;
            min-height:200px;
       }
       /* Hide the carousel text when the screen is less than 600 pixels wide */
       @media (max-width: 600px) {
           .carousel-caption {
           display: none;
       }
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <body id="page-top" >

        <!-- Navigation -->
        <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll" style="margin-bottom: -33px;">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="#page-top">
                        <img style="position:fixed; left:1px;top:7px"class="img-responsive" 
                            src="images/logo_bus_stop.png" alt="" width = "85px" height = "85px">
                    </a>
                    <a class="navbar-brand" href="#page-top" style = "color:Teal; font-size:40px; font-family:Comic Sans MS;">
                        &nbsp;
                        BUS STOP</a>                    
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hidden">
                            <a href="#page-top"></a>
                        </li>
                         <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" style = " font-size:large;" "href="#">${pageContext.request.remoteUser}
                            <span></span></a>
                            <ul class="dropdown-menu">
                           <li><a href="/logout" style = " font-size:large;color:black">Logout</a></li>
                           </ul>
                        
                        <li class="page-scroll">
                            <a href="SearchBus.html">Search Bus</a>
                        </li>
                        
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
        <!-- Header -->
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <img class="img-responsive" src="images/load.gif" alt="">
                        <div class="intro-text" style= "height: 100px; padding-bottom: 8px; padding-top: 0px; ">
                            <span class="name">Start Journey</span>
                            <hr class="star-light">
                            <span class="skills">Welcome -Experience Travel Together</span>
                        </div>
                    </div>
                </div>    
            </div>
        </header>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
              <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#myCarousel" data-slide-to="1"></li>
              <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="images/slide5.jpg" alt="Image">
                </div>
                <div class="item">
                    <img src="images/slide2.jpg" alt="Image">
                </div>
                <div class="item">
                    <img src="images/slide6.jpg" alt="Image">
                </div>
            </div>
            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </body>
</html>