<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<title>View Low Priced Hotels</title>

<script type="text/javascript"
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script type="text/javascript">
        function doAjaxCall() {
       
        var name = $('#city').val();
        
        $.ajax({
        type: "POST",
        url: "/getTariff",
        data: "cityName=" + name,
        success: function(response){
        	var table = $('<table>');
			table.attr('border','1');
			var tr = $('<tr>');
			var td = $('<td>');
			td.html("City");
			tr.append(td);
			td = $('<td>');
			td.html("Hotel Name");
			tr.append(td);
			td = $('<td>');
			td.html("Tariff");
			tr.append(td);
			table.append(tr);

        	$.each(response, function(i, item) {
        		var tr = $('<tr>');
				var td = $('<td>');
				td.html(item.city);
				tr.append(td);
				td = $('<td>');
				td.html(item.hotelName);
				tr.append(td);
				td = $('<td>');
				td.html(item.tariff);
				tr.append(td);
				table.append(tr);
            });
        	$('#tariff-table').empty();
        	$('#tariff-table').append(table);
        },
        error: function(e){
        alert('Error: ' + e);
        }
        });
        }
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

	<form:form action="viewLowPriceHotels.jsp"
		modelAttribute="hotelform">

		<table align="center" width="50%">
			<tr>
				<td><h1>View Low Priced Hotels</h1></td>
				<br>
				<br>
				<br>
			</tr>
		</table>
		
		<table align="center" width="50%">
		
		<tr>
			<td> City	</td>
			<td>
					<form:select path="city" onchange="doAjaxCall()">
						<form:option value="" label="--Please Select" />
						<form:options items="${CityList}" itemValue="cityName"
							itemLabel="cityName" />
					</form:select>

				</td>
		</tr>

		</table>
		
		<table align="center" width="50%" id="tariff-table" name="tariff-table">
		
		</table>
		
		<table align="center" width="50%">
		
			<tr>
				<td>
				  <a href="/home" class="button">Cancel</a>
				</td>
			</tr>
		</table>
		
	</form:form>
</body>
</html>
