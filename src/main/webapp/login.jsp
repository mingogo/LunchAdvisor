<!-- 
mteng:
The login page. Taking the request attributes (User name and password) and send it to the 
servlet (url: login_Serv.do) to check the database and see if the account/pwd pair is valid.
 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
	<head>
		<c:import url="RE_Header.jsp"></c:import>
		<title>Login in</title>
		<!-- Custom styles for this template -->
		<link href="css/signin.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<form class="form-signin" role="form" action = "login_Serv.do" method = "POST">
				<h2 class="form-signin-heading">Sign in to iServ v.3</h2>
				<input type="text" name = "Attrb_accnt" class="form-control" placeholder="Account" autofocus required>
				<input type="password" name = "Attrb_psswrd" class="form-control" placeholder="Password" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			</form> <!-- End of the form -->
		</div> <!-- /container -->
	</body>
</html>
