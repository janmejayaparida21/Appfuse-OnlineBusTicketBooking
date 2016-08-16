<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" style="border-top-style: solid; border-top-width: 0px; margin-top: -22px;">

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
   .bodyColor {
  text-align: center;
  /*background: #18BC9C;*/
  	/*background: url("images/back.jpg") 30% 30%;*/
        
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
    width: 50%;
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
    background-color:  #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
}
.button2:hover { 
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}

#main {
   height:500px;
   
}

#PayVisible {
   height:600px; 
   border:1px solid black;
}

.five{
  width:100px;
  height:100px;
background:blue;
}

    
</style>
  <script>
  
  
  </script>
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
                <a class="navbarleft-brand" href="#page-top" style = "text-decoration:none; color:white; font-size:40px; font-family:Comic Sans MS;">
                &nbsp;
                BUS STOP</a>                     
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"><form>
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                         <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" style = " font-size:large;" "href="#">Hi!! ${pageContext.request.remoteUser}
                            <span></span></a>
                            <ul class="dropdown-menu">
                           <li><a href="logOut.html" style = " font-size:large;color:black">Logout</a></li>
                           </ul>
                    
                    <li class="page-scroll">
                        <a href="SearchBus.html" style = " font-size:large;">Search Bus</a>
                    </li>
                </ul></form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>      
    <div  id = "main" class = "body" style="border-top-width: 125px;background-color : white;padding-top: 30px;">
          <center><h3>!!! Book Your Ticket Now !!!</h3></center>
          <c:forEach items = "${tripRoute}" var = "tripRoute">
             <form id ="booking_info" action = "payment.html"  onsubmit="return formValidation()" method = "post"><br><br><br>
             	<table align = "center" style = "font-size:20px; font-family:Comic Sans MS;">
             	<tr><td>Travels</td>
                   <td><c:out value="${tripRoute.trip.bus.travels.name}"/></td></tr>
                   <tr><td>Bus Type</td><td>
                   <c:out value="${tripRoute.trip.bus.type}"/></td></tr>
                   <tr><td>AC/Non-AC</td><td>
                   <c:if test="${tripRoute.trip.bus.isAc}">
                        AC
                   </c:if>
                   <c:if test="${!tripRoute.trip.bus.isAc}">
                         Non-AC
                   </c:if></td></tr>
                  <tr><td>Departure Time</td><td>                            
                  <c:out value="${tripRoute.departureTime}"/></td></tr>
                  <tr><td>Arrival Time</td><td>
                  <c:out value="${tripRoute.arrivalTime}"/></td></tr>
                  <tr><td>Number of Available Seats</td><td>
                  <c:out value="${tripRoute.trip.seatVacancy}"/></td></tr>
                  <tr><td>Ticket Fair</td><td>
                  <input type="hidden" id="unitprice" name="unitprice" value="${tripRoute.price}"/>
                  <c:out value="${tripRoute.price}"/></td></tr>
                  <tr><td>Number of Passengers:</td><td><input type="number" min="0" name = "noOfSeatsBooked" id="noOfSeatsBooked" onchange="CalculateFare()"/></td></tr>
                  <tr><td>
                  <tr><td>Total Price:</td><td><p  name = "TotalPrice" id="TotalPrice"></p></td></tr>
                  <input type="hidden" id="totalPrice" name="totalPrice"/>
                  <tr><td>
                  <tr><td>Select PaymentMode</td>
                  <td><select class="form-control"style="width:250Px" name="paymentMode"  id="paymentMode" >
                      <option >--Select paymentMode--</option>
                      <option value="Credit Card"><b>Credit Card</b></option>
                      <option value="Debit Card"><b>Debit Card</b></option>
                      <option value="Net Banking"><b>Net Banking</b></option>
                      </select></td></tr>
                  <tr align="center" >
                      <td align="center"><a href="SearchBus.html"><center><input type="button" value = "Cancel" name = "cancel"/></center> </a></td>
                      <td align="center"><center><input id = "pay" type = "submit" value = "Confirm"  ></center></td>
                   </tr>
                   <input type="hidden" id="seatVacancy" name="seatVacancy" value="${tripRoute.trip.seatVacancy}"/>
                 
                </table><br><br><br><br><br><br> 
                
                </div> 
                    
             </form>
          </c:forEach> 
          
          
    <script type="text/javascript">
        
        function CalculateFare() {
        	var ticketCount = document.getElementById("noOfSeatsBooked").value;
        	var unitprice = document.getElementById("unitprice").value;
        	
        	if(ticketCount > -1) {
        		var totalprice = ticketCount*unitprice;
           	    document.getElementById("TotalPrice").innerHTML = totalprice;
           	 document.getElementById("totalPrice").value = totalprice;
        	}
        	
        }

        
        function formValidation(){
        	var numberOfPassengers = Number(document.getElementById("noOfSeatsBooked").value);
        	var paymentMode =  document.getElementById("paymentMode").value;
        	var seatVacancy = parseInt(document.getElementById("seatVacancy").value);

        	
        	if((numberOfPassengers == '0') || (numberOfPassengers == '')){
        		alert("Please!! mention number of passengers");
        		return false;
        	}
        	else if(paymentMode == "--Select paymentMode--"){
        		alert("Please!! Select mode of payment");
        		return false;
        	}
        	else if (numberOfPassengers > seatVacancy) {
        		alert("sorry!!!we don't have enough seats");
        		return false;
        	}
        	
        	
        }
    </script>
   </div>  
</body>
</html>