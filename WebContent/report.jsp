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

<h2>Your Order</h2>


<table border="1" cellspacing="5px" cellpadding="5px">

<tr>Order Details</tr>
<tr>
<th>Item</th>
<th>Quantity</th>
<th>Price</th>
<th>Date of Purchase</th>
</tr>
<c:forEach items="${items }" var="item">
<tr>
<td>${item.name }</td>
<td>${item.quantity }</td>
<td>${item.price }</td>
<td>${Date }</td>

</tr>
</c:forEach>

</table>

<br></br>



<p><strong>Customer Details</strong></p>

Customer Name : ${name }
<br></br>
Delivery Address : ${address }
<br></br>
Contact Number : ${mobile }
<br></br>
Email ID :  ${email }

<h2>Total Payment</h2>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>