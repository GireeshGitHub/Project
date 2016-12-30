<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<title>Book A Room</title>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css">
 
  <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
  <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<!-- <script type="text/javascript"
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script> -->

<style>
    .error {
        color: red; font-weight: bold;
    }
</style>    
<script type="text/javascript">
function doAjaxCall1() {
    
    var name = $('#city').val();
    
    $.ajax({
    type: "POST",
    url: "/getHotels",
    data: "cityName=" + name,
    success: function(response){
    	
    	var select = $("#hotelName"), options = '';
        
    	$.each(response, function(i, item) {
    		//combined id and tariff to avoid multiple hit to DB during booking
    		options += "<option value='"+item.hotelId+"~"+item.tariff+"~"+item.numberOfRooms+"'>"+ item.hotelName +"</option>";  
    		//$('hotelName').append('<option value="' + item.hotelId + '">' + item.hotelName + '</option>');
        
        });
    	select.append(options);
    	
    },
    error: function(e){
    alert('Error: ' + e);
    }
    });
    }
 </script>
 
 <script type="text/javascript">  
$( function() {
    $( "#checkinDate" ).datepicker();
  } );
  
$( function() {
    $( "#checkoutDate" ).datepicker();
  } );
</script>

<style>
.button {
    display: block;
    width: 100px;
    height: 15px;
    background: gray;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
}

.button1 {
    display: block;
    width: 100px;
    height: 40px;
    background: gray;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
}
</style>


</head>
<body width="50%" bgcolor="white" >

	<form:form action="bookRoom"
		modelAttribute="hotelform">

		<table align="center" width="50%">
			<tr>
				<td><h1>Book A Room</h1></td>
				<br>
				<br>
				<br>
			</tr>
		</table>
		
		<table align="center" width="50%">
		
		<tr>
			<td> City	</td>
			<td>
					<form:select path="city" onchange="doAjaxCall1()">
						<form:option value="" label="--Please Select" />
						<form:options items="${CityList}" itemValue="cityName"
							itemLabel="cityName" />
					</form:select>

			</td>
			<td > <form:errors path="city" cssClass="error"/></td>
				
			<td> Hotel	</td>
			<td>
					<form:select path="hotelName" >
						<form:option value="" label="--Please Select" />
					</form:select>

				</td>	
				<td > <form:errors path="hotelName" cssClass="error"/></td>
		</tr>
		<tr>
		
			<p><td>
			   Check-in date:
			</td>
			<td>
					<form:input path="checkinDate" />
			</td>
			<td > <form:errors path="checkinDate" cssClass="error"/></td>
			</p>
			
			<p><td>
			   Check-out date:
			</td>
			<td>
					<form:input path="checkoutDate" />
			</td>
			<td > <form:errors path="checkoutDate" cssClass="error"/></td>
			</p>
		</tr>
		
		<tr>
			<td>Number of Rooms:</td>
			<td>
					<form:input path="numberOfRooms" />
			</td>
			<td > <form:errors path="numberOfRooms" cssClass="error"/></td>
		</tr>

		</table>
		
		<table align="center" width="50%" id="tariff-table" name="tariff-table">
		
		</table>
		
		<table align="center" width="50%">
		
			<tr>
				<td>
				<form:button class="button1"  value="Book Room">Book Room</form:button>
				 
				</td>
				<td>
				  <a href="/home" class="button">Cancel</a>
				</td>
			</tr>
		</table>
		
	</form:form>
</body>
</html>
