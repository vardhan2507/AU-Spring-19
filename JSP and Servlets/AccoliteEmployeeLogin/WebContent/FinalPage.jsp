<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">
    <title>Profile Page</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/MainReg.css" rel="stylesheet" media="all">
</head>
<body>
<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h3 class="title">Congrats <%= request.getParameter("username")%> Your Profile is Updated!</h3>
                </div>
                <div class="card-body">
                <form  action="index.jsp" method="POST">
                <div align="center">
                            <button class="btn btn--radius-2 btn--red" type="submit">Logout</button>
                        </div>
                         </form>
                
<%@ page import="java.sql.*" %>
<%! Connection con=null; %>
<%! com.accolite.model.User user=null; %>
<% 
try {
	
	 
	Class.forName((String)application.getInitParameter("driver"));
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//creating connection with the database 
try {
	 con=DriverManager.getConnection(application.getInitParameter("dbURL"),application.getInitParameter("username"),application.getInitParameter("password"));
	 user=new com.accolite.model.User();
	
	user.setUsername((String)request.getParameter("username"));
	user.setPassword((String)request.getParameter("password"));
	user.setNickname((String)request.getParameter("nickname"));
	user.setCity((String)request.getParameter("city"));	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>

<%
	try{
	Statement s=con.createStatement();
	s.executeUpdate("update users set username='"+user.getUsername()+"', password='"+user.getPassword()+"', nickname='"+user.getNickname()+"', city='"+user.getCity()+"' where username='"+user.getUsername()+"'");  

	con.commit();
	
	}catch(Exception e){e.printStackTrace();}


%>


</div>
                </div>
                </div>
                </div>

</body>
</html>