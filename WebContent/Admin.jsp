<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Corona Care-Home</title>
</head>
<body>
<div>

<hr/>
	<h2>Admin Login</h2>
	<form action="adminlogin" method="post">
		<div>
			<div><label for="loginid">Enter login Id</label> </div>
			<div><input type="text" id="loginid" name="loginid"></div>
		</div>
		<div>
			<div><label for="password">Enter password</label> </div>
			<div><input type="text" id="password" name="password"></div>
		</div>
		<div>
		<br></br>
		<div><a href="AdminPortal.jsp">Submit</a> </div>
		</div>
	</form>
</div>
<hr/>



<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>