<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page isELIgnored="false" %>
    
    <%@ page import="com.accolite.au.model.User" %>
    
    <%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table border=1>
 <tr>
 
 <th>Username</th>
 <th>Name</th>
 <th>Location</th>
 </tr>
   <c:forEach var="user" items="${users}">
       <tr>      
       <td>${user.getUsername()}</td>
       <td>${user.getName()}</td>
       <td>${user.getLocation()}</td>
       </tr>     
   </c:forEach>  
   </table>
 
</body>
</html>