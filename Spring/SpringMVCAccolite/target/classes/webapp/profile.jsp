<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>
<form action="update" method="post">
		<pre>
	    
		
		Username: <input type="text" name="username" value="${user.getUsername() }"/>
		
		Password: <input type="password" name="password" value="${user.getPassword() }"/>
		
		Name: <input type="text" name="name" value="${user.getName() }"/>
		
		Location: <input type="text" name="location" value="${user.getLocation() }"/>
		
		<input type="submit" value="Update"/>
	</pre>
	</form>


</p>
</body>
</html>