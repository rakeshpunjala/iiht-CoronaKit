<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Edit Product(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<form action="saveitem" method="POST">
	
		<div>
			<label>Item Name</label>
			<input type="text" name="item" value="${kit.productName }" readonly required/>
		</div>
		<div>
			<label>Price</label>
			<input type="number" name="price" value="${kit.price }" required/>
		</div>
		<div>
			<label>Quantity</label>
			<input type="number" name="quantity" value="${kit.quantity }" required/>
		</div>
		
		<button>SAVE</button>
	</form>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>