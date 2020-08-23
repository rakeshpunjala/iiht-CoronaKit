<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<h2>List of All Products</h2>
<form action="listproducts" method="GET">
<button>Click here for all Products</button>
</form>
<br></br>
<c:choose>

<c:when test="${allproducts!=null || !allproducts.isEmpty() }">
<table border="1" cellspacing="5px" cellpadding="5px">
<tr>

<th>Item Name</th>
<th>Price Per Piece (Rs)</th>
<th>Quantity Available</th>
<th>Action</th>

</tr>
<c:forEach items="${allproducts }" var="product">
<tr>
<td>${product.productName }</td>
<td>${product.price }</td>
<td>${product.quantity }</td>

<td>
<a href="deleteContact?cid=${product.productName }">DELETE</a>
<span> </span>
<a href="editContact?cid=${product.productName }">EDIT</a>
</td>
</c:forEach>

</table>
</c:when>
<c:otherwise>
<p>No Products Found Try<a href="newContact">Adding</a>one</p>
</c:otherwise>
</c:choose>


<%-- Required View Template --%>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>