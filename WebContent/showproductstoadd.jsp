<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, td, th {
border: 1px solid black;           
}
</style>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<a href="index.jsp">Home</a>
<br></br>

<form action="showproductstoadd">
<fieldset>
<legend>Shopping cart</legend>
<br></br>
<table>
<th>Item</th>
<th>Quantity</th>
<th>@Each item</th>
<th colspan='2'>Add/Del</th>
<th>Price</th>

<tr>
<td><input type="checkbox" name="names" value="FaceMask"/>Face Mask</td>
<td><input type="number" name="Quantity1"></td>
<td style="text-align:center">100 Rs</td>
<td><button>Add</button></td>
<td><button>clear</button></td>
<td style="text-align:center">${price1 }</td>
</tr>

<tr>
<td><input type="checkbox" name="names" value="Sanitizer"/>Sanitizer</td>
<td><input type="number" name="Quantity2"></td>
<td style="text-align:center">50 Rs</td>
<td><button>Add</button></td>
<td><button>clear</button></td>
<td style="text-align:center">${price2 }</td>
</tr>

<tr>
<td><input type="checkbox" name="names" value="Medicines"/>Corona Antibiotics</td>
<td><input type="number" name="Quantity3"></td>
<td style="text-align:center">200 Rs</td>
<td><button>Add</button></td>
<td><button>clear</button></td>
<td style="text-align:center">${price3 }</td>
</tr>

</table>
</fieldset>
<br></br>
</form> 

<a href="ordersummary">Place Order</a>  

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>