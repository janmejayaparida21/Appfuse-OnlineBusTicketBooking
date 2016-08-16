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
      background-color : black;
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
                 <a class="navbar-brand" href="#page-top"><img style="position:fixed; left:1px;top:7px"class="img-responsive" src="images/logo_bus_stop.png" alt="" width = "85px" height = "85px"></a>
                <a class="navbar-brand" href="#page-top" style = "color:white; font-size:40px; font-family:Comic Sans MS;">
                &nbsp;
                BUS STOP</a>                     
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"><form>
            <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    <li class="page-scroll">
                      <a href="profile.html" style = "text-decoration : none; font-size:large;">Hi!! ${pageContext.request.remoteUser}</a>
                    </li>
                    <li class="page-scroll">
                      <a href="logout.html" style = "text-decoration : none; font-size:large;">Logout</a>
                    </li>
                    <li class="page-scroll">
                      <a href="SearchBus.html" style = "text-decoration : none; font-size:large;">SearchBus</a>
                    </li>
                    
                </ul>
                </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>     
    <div  id = "main" class = "body" style="border-top-width: 125px;background-color : 	#FFE4C4;padding-top: 30px;">
         <center><h3 style = "color : black;">Hai ${reservation.user.username} ... Here is your Ticket</h3></center><br>           	
             <table class = "table table-striped" align = "center" style = "font-size:20px; font-family:Comic Sans MS; width:75%;">
             	<tr><td>Travels</td>
                   <td>${reservation.tripRoute.trip.bus.travels.name}</td></tr>
                   <tr><td>Bus Number</td>
                   <td>${reservation.tripRoute.trip.bus.registrationNumber}</td></tr>
                   <tr><td>Bus Type</td><td>
                   ${reservation.tripRoute.trip.bus.type}</td></tr>
                   <tr><td>AC/Non-AC</td><td>
                   <c:if test="${reservation.tripRoute.trip.bus.isAc}">
                        AC
                   </c:if>
                   <c:if test="${!reservation.tripRoute.trip.bus.isAc}">
                         Non-AC
                   </c:if></td></tr>
                   <tr><td>Source </td>
                   <td>${reservation.tripRoute.route.sourceCity.name}</td></tr>
                   <tr><td>Destination </td>
                   <td>${reservation.tripRoute.route.destinationCity.name}</td></tr>
                   <tr><td>Date Of Travel </td>
                   <td>${reservation.tripRoute.dateOfTravel}</td></tr>
                  <tr><td>Departure Time</td><td>                            
                  ${reservation.tripRoute.departureTime}</td></tr>
                  <tr><td>Arrival Time</td><td>
                  ${reservation.tripRoute.arrivalTime}</td></tr>
                  <tr><td>Number of Seats Booked:</td><td>
                  ${reservation.noOfSeatsBooked}
                  </td></tr>
                  <tr><td>Ticket Fare for one passenger</td><td>
                  ${reservation.tripRoute.price}</td></tr>
                  <tr><td>Total Price:</td><td>${reservation.totalPrice}</td></tr>
                  <tr><td>PaymentMode</td>
                  <td>Your payment is done through ${reservation.paymentMode} </td></tr>
                </table><br><center>
                <input type = "button" value = "Mail Ticket" onclick = "show()"/></center>
                <center>
                <h4 style = "color = black;"> Note :</h4></center><center>
                <p> Come 15 mins prior to your departure time</p></center><center>
                <h3>!!! Have A Safe Journey dear ${reservation.user.username} !!!</h3></center>

     </div> 
                 <script>              
                    function show() {
                        alert("Your ticket has been sent tou your registered mobile number and mail-id");
                    } 
                </script>
</body>
</html>


