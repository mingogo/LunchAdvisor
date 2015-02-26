<!-- 
mteng:
The page displayed if the login (Manager) was successful.
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url="RE_Header.jsp"/>
</head>
  <body>
	<c:import url="RE_MenuBanner.jsp"/>

	<br>
	<center>
	<div class="jumbotron">
      <h1>Welcome back, Manager.</h1>
		<p class="lead">Select your module from the Nav bar above.</p>
		<p class="lead">${title}</p>

    </div>
    </center>

	<c:import url="RE_FooterForLoadFaster.jsp"/>
  </body>
</html>