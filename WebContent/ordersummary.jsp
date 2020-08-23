<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<c:when test="${items==null || items.isEmpty() }">
<p>No items ordered<a href="showproductstoadd.jsp"> &nbsp; Add Items</a></p>
</c:when>
<c:otherwise>
<table border="1" cellspacing="5px" cellpadding="5px">
<tr>
<th>Item</th>
<th>Quantity</th>
<th>Price</th>
</tr>
<c:forEach items="${items }" var="item">
<tr>
<td>${item.name }</td>
<td>${item.quantity }</td>
<td>${item.price }</td>

</tr>
</c:forEach>

</table>
</c:otherwise>
</c:choose>
<br></br>

<a href="showproductstoadd.jsp">Go Back To Edit the Order</a> &nbsp; <a href="report.jsp">Check Out</a>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>