<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
</head>

<body>
<jsp:include page="header.jsp"/>
<hr/>

<h3>Please fill below details to buy Corona Kit</h3>

<form action="newuser">
<label>Title : 
<select name="title" required>
<option value ="">--Select--</option>
<option value ="Mr.">--Mr.--</option>
<option value ="Miss.">--Miss.--</option>
<option value ="Mrs.">--Mrs.--</option>
</select>
</label> <br></br>

<label> Full Name: <input type="text" name ="fullname" required/></label> <br></br>
<label> Address: <input type="text" name ="Address" required/></label> <br></br>
<label> Email ID: <input type="text" name ="EmailID" required/></label> <br></br>
<label> Contact Number: <input type="number" name ="Mobile" required/></label> <br></br>
<button>save</button>

</form>

<p>${name }</p>




<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>