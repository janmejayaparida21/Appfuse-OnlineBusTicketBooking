<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.i2i.model.TripRoute" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Available Buses</title>
    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="styles/freelancer.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
   
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   
    <!-- Load SCRIPT.JS which will create datepicker for input field  -->
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

</head>
<style>
.bodyColor {
    text-align: center;
    color: white;
} 
table tr:nth-child(odd) {
    background-color: #f1f1f1;
}
table tr:nth-child(even) {
    background-color: #ffffff;
}
table {
    border-collapse: collapse;
    width: 100%;
}
th, td {
    text-align: left;
    padding: 8px;
    color:black;
}
th {
    text-align: center;
    background-color: #18BC9C;
    color: white;
}
.button {
    border-radius: 8px;
    background-color:  #f44336;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    width:20%
    cursor: pointer;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
}
.button2:hover { 
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>

<body id="page-top" class="bodyColor">

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <a class="navbar-brand" href="#page-top"><img style="position:fixed; left:1px;top:7px"class="img-responsive" src="images/logo_bus_stop.png" alt="" width = "85px" height = "85px"></a>
                <a class="navbar-brand" href="#page-top" style = "color:white; font-size:40px; font-family:Comic Sans MS; important">
                &nbsp;
                BUS STOP</a> 
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                
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
                           <li><a href="logout.html" style = " font-size:large;color:black">Logout</a></li>
                           </ul>
                    
                    <li class="page-scroll">
                      <a href="SearchBus.html" style = " font-size:large;">Back</a>
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
 <!-- Printing TripRoutes -->   
<div style="border-top-width: 125px; border-top-style: solid;">
<c:if test="${!empty tripRoutes}">
    <table style="border-top-width: 7px; border-top-style: solid;">
         <tr style="border-top-width: 32px; border-top-style: solid;">
             <th>Travels</th>
             <th width="40%" align="left">DepatureTime &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ArrivalTime</th>
             <th width="20%">AvailableSeats</th>
             <th width="30%">Price</th>
             <th></th>
          </tr>
         <c:forEach items="${tripRoutes}" var="tripRoutes">
         <form:form id = "tripRoute" action="ConfirmBooking.html" method="post" >
         <input type="hidden" id ="tripRoutes" name="tripRoutes" value="${tripRoutes.id}"  />
         <b><tr style="border-top-style: solid; border-top-width: 26px;">
             <td width="20%"><i class="fa fa-bus" style="font-size:24px;color:black"></i><span style="padding-left:20px"><b><c:out value="${tripRoutes.trip.bus.travels.name}"/></b></span></br><span style="padding-left:40px"><c:out value="${tripRoutes.trip.bus.type}"/></span></br>
             <c:if test="${tripRoutes.trip.bus.isAc}">
             <span style="padding-left:40px"> <b>AC</b></span>
             </c:if>
             <c:if test="${!tripRoutes.trip.bus.isAc}">
             <span style="padding-left:40px"> <b>Non AC</b></span>
             </c:if>
             </td>
             <td id="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-clock-o" style="font-size:24px;color:black"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${tripRoutes.departureTime}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${tripRoutes.arrivalTime}"/></td>
             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="material-icons" style="font-size:24px:color:black"></i><img height="30" width="20"  src="images/seat.png" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${tripRoutes.trip.seatVacancy}"/></td>
             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-inr" style="font-size:26px;color:black"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${tripRoutes.price}"/></td> 
             <td><button class="button button2">Book</button></td>
             </tr></b>
             </form:form>
             </c:forEach>
    </table>
</c:if>
<!-- Display No bus if no Triproute bus Available -->
<c:if test="${empty tripRoutes}">
    <div style="border-top-width: 200px; border-top-style: solid;">
    <h1 style="color:black">Sorry!!! currently no Buses Available</h1>
    </div>
</c:if>
</div>

</body>
</html>