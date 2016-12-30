<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<title>Booking Failure</title>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css">
 
  <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
  <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<!-- <script type="text/javascript"
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script> -->
<script type="text/javascript">
function doAjaxCall() {
    
    var name = $('#city').val();
    
    $.ajax({
    type: "POST",
    url: "/getHotels",
    data: "cityName=" + name,
    success: function(response){
    	
    	var select = $("#hotelName"), options = '';
        
    	$.each(response, function(i, item) {
    		options += "<option value='"+item.hotelId+"'>"+ item.hotelName +"</option>";  
    		//$('hotelName').append('<option value="' + item.hotelId + '">' + item.hotelName + '</option>');
        
        });
    	select.append(options);
    	
    },
    error: function(e){
    alert('Error: ' + e);
    }
    });
    }
    
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
</style>


</head>
<body width="50%" bgcolor="white" >

	<form:form action="bookRoom"
		modelAttribute="hotelform">

		<table align="center" width="50%">
			<tr>
				<td><h2>Rooms are not available in the selected range of dates for selected Hotel. </h2></td>
				<br>
				<br>
				<br>
			</tr>
		</table>
		
		
		
		<table align="center" width="50%">
		
			<tr>
				
				<td>
				  <a href="/home" class="button">Home Page</a>
				</td>
			</tr>
		</table>
		
	</form:form>
</body>
</html>
