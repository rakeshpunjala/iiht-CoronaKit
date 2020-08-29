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
<a href="index.jsp">HOME</a>
<h2>Your Order</h2>



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

</table>





<p><strong>Customer Details</strong></p>

Customer Name : ${name }
<br></br>
Delivery Address : ${address }
<br></br>
Contact Number : ${mobile }
<br></br>
Email ID :  ${email }

<h2>Total Payment : <Strong>${finalpayment }</Strong> </h2> 

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>