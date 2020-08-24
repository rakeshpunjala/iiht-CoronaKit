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

<form action="deleteitems">
<fieldset>
<legend>Delete Products</legend>
<br></br>
<label for="item">Select Item</label>

<select name="items" id="items">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="mercedes">Mercedes</option>
  <option value="audi">Audi</option>
</select>
</fieldset>
<br></br>
</form> 
<a href="AdminPortal.jsp">Back to Admin Portal</a>    

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>