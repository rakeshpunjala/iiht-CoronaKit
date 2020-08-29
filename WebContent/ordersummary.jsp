<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Order Summary(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<h2>Order Summary</h2>

	<c:choose>
		<c:when test="${kits == null || kits.isEmpty() }">
			<p>No Items Found Try <a href="newContact">adding</a> one</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Item</th>
					<th>Quantity</th>
					<th>@Each item</th>
					<th>Amount</th>
					
				</tr>
				<c:forEach items="${kits }" var="kit">
					<tr>
						<td>${kit.productName }</td>
						<td>${kit.quantity }</td>
						<td>${kit.price }</td>
						<td>${kit.totalamount }</td>
						
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

<br></br>
<a href="showproductstoadd.jsp">Edit the Order</a> &nbsp; <a href="checkout">Check Out</a>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>