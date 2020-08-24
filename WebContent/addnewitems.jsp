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

<form action="addnewitems">
<fieldset>
<legend>Add New Products</legend>
<br></br>
<table>
<th>Enter Item Name</th>
<th>Enter Quantity</th>
<th>Enter Price</th>
<th>Add</th>

<tr>
<td><input type="text" name="itemname"/></td>
<td><input type="number" name="quantity"></td>
<td><input type="number" name="price"></td>
<td><button>Add</button></td>


</table>
</fieldset>
<br></br>
</form> 
<a href="AdminPortal.jsp">Back to Admin Portal</a>    

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>