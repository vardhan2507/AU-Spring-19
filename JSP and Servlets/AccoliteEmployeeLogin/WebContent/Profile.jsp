<!DOCTYPE html>
<html lang="en">

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
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from users where username='"+ (String)request.getAttribute("username")+"'");
	while (rs.next()){
	user.setUsername(rs.getString("username"));
	user.setPassword(rs.getString("password"));
	user.setNickname(rs.getString("nickname"));
	user.setCity(rs.getString("city"));
	}
	
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>




    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Welcome <%=request.getAttribute("username") %></h2>
                </div>
                <div class="card-body">
                    <form  action="FinalPage.jsp" method="POST">
                   
                        <div class="form-row">
                            <div class="name">Username</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="username" value=<%= user.getUsername() %>>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Password</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="password" name="password" value=<%= user.getPassword() %>>
                                </div>
                            </div>
                        </div>
                                     <div class="form-row">
                            <div class="name">Nickname</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="nickname" value=<%= user.getNickname() %>>
                                </div>
                            </div>
                        </div>          
                        <div>
                          <div class="form-row">
                            <div class="name">City</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="city" value=<%= user.getCity() %>>
                                </div>
                            </div>
                        </div>
                            <button class="btn btn--radius-2 btn--red" type="submit">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body>
</html>
<!-- end document-->