<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Portal</title>
</head>
<body>

<hr/>

<h1>Welcome To Admin Portal</h1>

<hr>
<form action="listproducts" method="GET">
<button>All Items</button> &nbsp;
<a href="addnewitems.jsp">Add Items</a>  
</form>

<c:if test="${msg != null }">
		<p><strong>${msg }</strong>
</c:if>



</hr>

</body>
</html>